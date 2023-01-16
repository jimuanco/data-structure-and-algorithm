package Lecture.DFS_BFS_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//class Point {
//    public int x, y;
//    Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}

//토마토(BFS)
public class Ex12 {
    static int n,m;

    static int cnt=0;
    static int answer=Integer.MIN_VALUE;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int[][] board,dis;
    static Queue<Point> Q = new LinkedList<>();

    public static void BFS() {
//        Queue<Point> Q = new LinkedList<>();
//        for(int i=1; i<=n; i++) {
//            for(int j=1; j<=m; j++) {
//                if(board[i][j]==1) {
//                    Q.offer(new Point(i, j));
//                    cnt++;
//                }
//                if(board[i][j]==-1) cnt++;
//            }
//        }
        if(cnt==n*m) {
            answer=0;
            return;
        }
        while(!Q.isEmpty()) {
            Point tmp = Q.poll();
            for(int i=0; i<4; i++) {
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];
                if(nx>=1 && nx<=n && ny>=1 && ny<=m && board[nx][ny]==0) {
                    board[nx][ny]=1;
                    Q.offer(new Point(nx,ny));
                    dis[nx][ny]=dis[tmp.x][tmp.y]+1;
                    cnt++;
                    answer=Math.max(dis[nx][ny],answer);
                }
            }
        }
        if(cnt!=n*m) {
            answer=-1;
//            return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n+1][m+1];
        dis = new int[n+1][m+1];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
                if(board[i][j]==1) {
                    Q.offer(new Point(i, j));
                    cnt++;
                }
                if(board[i][j]==-1) cnt++;
            }
        }
        BFS();
        System.out.println(answer);
    }
}
