package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//나이트의 이동
class Point {
    public int x, y;
    Point(int x, int y) {
        this.x=x;
        this.y=y;
    }
}

public class Ex7562 {
    static int[] dx={1,2,2,1,-1,-2,-2,-1};
    static int[] dy={-2,-1,1,2,2,1,-1,-2};
    static int sx,sy,ex,ey,l;
    static int[][] graph, road;
    static StringBuilder sb = new StringBuilder();
    public static void BFS() {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(sx,sy));
        graph[sx][sy]=1;
        while(!Q.isEmpty()) {
            Point tmp=Q.poll();
            if(tmp.x==ex && tmp.y==ey) {
                sb.append(road[tmp.x][tmp.y]+"\n");
                return;
            }
            for(int i=0; i<8; i++) {
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];
                if(nx>=0 && nx<l && ny>=0 && ny<l && graph[nx][ny]==0) {
                    graph[nx][ny]=1;
                    Q.offer(new Point(nx,ny));
                    road[nx][ny]=road[tmp.x][tmp.y]+1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            l=Integer.parseInt(br.readLine());
            graph=new int[l][l];
            road=new int[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            sx=Integer.parseInt(st.nextToken());
            sy=Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ex=Integer.parseInt(st.nextToken());
            ey=Integer.parseInt(st.nextToken());
            BFS();
        }
        System.out.println(sb);
    }
}
