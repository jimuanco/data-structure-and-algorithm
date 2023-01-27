package Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point3 {
    public int x, y,ch,cnt;
    Point3(int x, int y, int ch, int cnt) {
        this.x=x;
        this.y=y;
        this.ch=ch;
        this.cnt=cnt;
    }
}

//벽 부수고 이동하기
public class Ex2206_memoryExceeded2 {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int n,m;
    static int[][] graph, visited;
    static boolean flag=false;
    public static void BFS(int x, int y) {
        Queue<Point3> Q = new LinkedList<>();
        Q.offer(new Point3(x,y,0,1));
        while(!Q.isEmpty()) {
            Point3 tmp = Q.poll();
            for(int i=0; i<4; i++) {
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && tmp.cnt+1==visited[nx][ny] && tmp.ch==0) { //벽을 안부수고 간게 부수고 간거 보다 특정 위치에 늦게 도착할 수도 있음 따라서 여기서 틀림
                    visited[nx][ny]=0;
                }
                if(nx>=0 && nx<n && ny>=0 && ny<m && visited[nx][ny]==0) {
                    if(graph[nx][ny]==1 && tmp.ch==1) continue;
                    tmp.cnt++;
                    visited[nx][ny]=tmp.cnt;
                    if(graph[nx][ny]==1) {
                        tmp.ch++;
                        Q.offer(new Point3(nx,ny,tmp.ch--,tmp.cnt--));
                    } else {
                        Q.offer(new Point3(nx,ny,tmp.ch,tmp.cnt--));
                    }
                    if(nx==n-1 && ny==m-1) {
//                        System.out.println(visited[nx][ny]);
                        flag=true;
                        break;
                    }
                }
            }
            if(flag) break;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph=new int[n][m];
        visited=new int[n][m];
        for(int i=0; i<n; i++) {
            String input=br.readLine();
            char[] ch=input.toCharArray();
            for(int j=0; j<m; j++) {
                graph[i][j]=ch[j]-'0';
            }
        }
        BFS(0,0);
        if(visited[n-1][m-1]!=0) {
            System.out.println(visited[n-1][m-1]);
        } else {
            System.out.println(-1);
        }
    }
}
