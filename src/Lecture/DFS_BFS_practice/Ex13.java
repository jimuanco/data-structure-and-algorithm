package Lecture.DFS_BFS_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//섬나라 아일랜드(DFS)
public class Ex13 {

    static int n;
    static int answer=0;
    static int[] dx={-1,-1,-1,0,1,1,1,0};
    static int[] dy={-1,0,1,1,1,0,-1,-1};
    static int[][] board;
    public static void DFS(int x, int y) {
        for(int i=0; i<8; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==1) {
                board[nx][ny]=0;
                DFS(nx,ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board=new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j]==1) {
                    board[i][j]=0;
                    DFS(i,j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
