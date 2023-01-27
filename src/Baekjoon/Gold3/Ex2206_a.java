package Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point4 {
    int x,y,wall,road;
    Point4(int x, int y, int wall, int road) {
        this.x=x;
        this.y=y;
        this.wall=wall;
        this.road=road;
    }
}

//벽 부수고 이동하기
public class Ex2206_a {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int n,m;
    static int[][] graph;
    static int[][][] visited; //벽을 한 번 부수고 걍 경우와 부수지 않고 간 경우 따지기 위해 3차원 배열
    public static void BFS(int x, int y) {
        Queue<Point4> Q = new LinkedList<>();
        Q.offer(new Point4(x,y,0,1));
        while(!Q.isEmpty()) {
            Point4 tmp = Q.poll();
            if(tmp.x==n-1 && tmp.y==m-1) {
                System.out.println(tmp.road);
                return; //함수 종료(BFS)
            }
            for(int i=0; i<4; i++) {
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(graph[nx][ny]==0) {
                    if(tmp.wall==0 && visited[nx][ny][0]==0) {
                        visited[nx][ny][0]=1;
                        tmp.road++;
                        Q.offer(new Point4(nx,ny,0,tmp.road--));
                    } else if(tmp.wall==1 && visited[nx][ny][1]==0) {
                        visited[nx][ny][1]=1;
                        tmp.road++;
                        Q.offer(new Point4(nx,ny,1,tmp.road--));
                    }
                } else {
                    if(tmp.wall==0 && visited[nx][ny][1]==0) {
                        visited[nx][ny][1]=1;
                        tmp.road++;
                        Q.offer(new Point4(nx,ny,1,tmp.road--));
                    }
                }
            }
        }
        System.out.println(-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new int[n][m][2];
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            char[] ch = input.toCharArray();
            for(int j=0; j<m; j++) {
                graph[i][j]=ch[j]-'0';
            }
        }
        BFS(0,0);
    }
}
