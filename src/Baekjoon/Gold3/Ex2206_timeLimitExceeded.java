package Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    public int x, y;
    Point(int x, int y) {
        this.x=x;
        this.y=y;
    }
}

//벽 부수고 이동하기
public class Ex2206_timeLimitExceeded {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int n,m;
    static int[][] graph, visited, road;
    static boolean flag=false;
    public static void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y));
        visited[x][y]=1;
        road[x][y]=1;
        while(!Q.isEmpty()) {
            Point tmp = Q.poll();
            for(int i=0; i<4; i++) {
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && graph[nx][ny]==0 && visited[nx][ny]==0) {
                    visited[nx][ny]=1;
                    Q.offer(new Point(nx,ny));
                    road[nx][ny]=road[tmp.x][tmp.y]+1;
                    if(nx==n-1 && ny==m-1) {
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
        road=new int[n][m];
        ArrayList<Point> arr = new ArrayList<Point>();
        for(int i=0; i<n; i++) {
            String input=br.readLine();
            char[] ch=input.toCharArray();
            for(int j=0; j<m; j++) {
                int a=ch[j]-'0';
                graph[i][j]=a;
                if(a==1) {
                    arr.add(new Point(i,j));
                }
            }
        }
        int answer1 = 0, answer2=Integer.MAX_VALUE;
        for(Point ob : arr) {
            graph[ob.x][ob.y]=0;
            BFS(0,0);
            if(road[n-1][m-1]==0) answer1=-1;
            else {
                answer2=Math.min(answer2,road[n-1][m-1]);
            }
            graph[ob.x][ob.y]=1;
            visited = new int[n][m];
            road=new int[n][m];
        }
        if(answer2!=Integer.MAX_VALUE) {
            System.out.println(answer2);
        } else {
            System.out.println(answer1);
        }
    }
}
