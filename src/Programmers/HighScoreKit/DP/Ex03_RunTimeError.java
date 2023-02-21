package Programmers.HighScoreKit.DP;

import java.util.*;

class Point {
    int x,y,road;
    Point(int x, int y, int road) {
        this.x=x;
        this.y=y;
        this.road=road;
    }
}

//등굣길(Lv3)
/*
m	n	puddles	return
4	3	[[2, 2]]	4
 */

//런타임에러 및 시간초과
//DP로 풀어야 함
class Ex03 {
    static int[][] graph;
    static int[] dx={1,0};
    static int[] dy={0,1};
    static int min=Integer.MAX_VALUE;
    static int answer;
    static void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y,0));
        while(!Q.isEmpty()) {
            Point tmp = Q.poll();
            for(int i=0; i<2; i++) {
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];
                if(nx>=0 && nx<graph.length && ny>=0 && ny<graph[0].length && graph[nx][ny]!=1) { //!(nx==puddles[0][0]-1 && ny==puddles[0][1]-1) <-x,y좌표 따로 따질땐 이런식으로 해야됨(주의!)
                    if(nx==graph.length-1 && ny== graph[0].length-1) {
                        if(min>tmp.road) {
                            min=tmp.road;
                            answer=1;
                        } else if(min==tmp.road) {
                            answer++;
                        }
                    } else {
                        Q.offer(new Point(nx,ny,tmp.road+1));
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int m=4;
        int n=3;
        int[][] puddles={{2,2}};
        answer = 0;
        graph = new int[n][m];
        for(int i=0; i<puddles.length; i++) {
            graph[puddles[i][0]][puddles[i][1]]=1;
        }
        BFS(0,0);
        answer%=1000000007;
        System.out.println(answer);;
    }
}