package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//구간 합 구하기 5
public class Ex11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[][] arr=new int[n+1][n+1];
        int[][] dp=new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(j==0) dp[i][j]=arr[i][j];
                else dp[i][j]=arr[i][j]+dp[i][j-1];
            }
        }
        int[] answer=new int[m];
        for(int i=0; i<m; i++) {
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());
            for(int j=x1; j<=x2; j++) {
                answer[i]+=dp[j][y2]-dp[j][y1-1];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int x : answer) {
            sb.append(x+"\n");
        }
        System.out.println(sb);
    }
}
