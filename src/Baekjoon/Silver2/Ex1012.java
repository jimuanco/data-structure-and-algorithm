package Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//유기농 배추
public class Ex1012 {

    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int n, m, answer;
    static int[][] board;
    static ArrayList<Integer> arr;

    public static void DFS(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]==1) {
                board[nx][ny]=0;
                DFS(nx,ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            board = new int[n][m];
            for(int j=0; j<k; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                board[b][a]=1;
            }
            for(int l=0; l<n; l++) {
                for(int p=0; p<m; p++) {
                    if(board[l][p]==1) {
                        board[l][p]=0;
                        DFS(l,p);
                        answer++;
                    }
                }
            }
            arr.add(answer);
            answer=0;
        }
        StringBuilder sb = new StringBuilder();
        for(int x : arr) {
            sb.append(x+"\n");
        }
        System.out.println(sb);
    }
}
