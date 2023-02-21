package Programmers.HighScoreKit.DFS_BFS;

import java.util.*;

//게임 맵 최단거리(Lv2)
/*
maps	answer
[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	-1
 */
class Point {
    int x,y;
    Point(int x , int y) {
        this.x=x;
        this.y=y;
    }
}

class Ex03 {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int[][] visited, distance;
    static void BFS(int x, int y, int[][] maps) {
        visited[x][y]=1;
        distance[x][y]=1;
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y));
        while(!Q.isEmpty()) {
            Point tmp=Q.poll();
            for(int i=0; i<4; i++) {
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length && maps[nx][ny]==1 && visited[nx][ny]==0) {
                    visited[nx][ny]=1;
                    distance[nx][ny]=distance[tmp.x][tmp.y]+1;
                    Q.offer(new Point(nx,ny));
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] maps={{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int answer = 0;
        visited = new int[maps.length][maps[0].length];
        distance = new int[maps.length][maps[0].length];
        BFS(0,0,maps);
        answer=distance[maps.length-1][maps[0].length-1];
        if(answer==0) System.out.println(-1);
        System.out.println(answer);
    }
}