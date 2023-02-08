package Baekjoon.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//다리 놓기
//조합의 경우수(메모이제이션) -> Lecture.DFS_BFS_practice Ex07_a
public class Ex1010 {
    static int[][] dp=new int[30][30];
    public static int DFS(int n, int r) {
        if(dp[n][r]>0) return dp[n][r];
        if(n==r || r==0) return 1;
        else return dp[n][r]=DFS(n-1,r-1)+DFS(n-1,r);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int n=Integer.parseInt(st.nextToken());
            sb.append(DFS(n,r)+"\n");
        }
        System.out.println(sb);
    }
}
