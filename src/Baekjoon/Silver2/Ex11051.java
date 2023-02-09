package Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이항 계수2
//조합의 경우수(메모이제이션) -> Lecture.DFS_BFS_practice Ex07_a
public class Ex11051 {
    static long[][] dp=new long[1001][1001]; //1001주의!
    static long DFS(int n, int k) {
        if(dp[n][k]>0) return dp[n][k];
        if(n==k || k==0) return 1;
        else return dp[n][k]=(DFS(n-1,k-1)+DFS(n-1,k))%10007;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        System.out.println(DFS(n,k)); //여긴 10007로 안나눠도 되네?
    }
}
