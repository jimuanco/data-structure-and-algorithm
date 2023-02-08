package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//RGB거리
//재귀로도 풀 수 있음
public class Ex1149_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] cost=new int[n][3];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int red=Integer.parseInt(st.nextToken());
            int green=Integer.parseInt(st.nextToken());
            int blue=Integer.parseInt(st.nextToken());
            cost[i][0]=red;
            cost[i][1]=green;
            cost[i][2]=blue;
        }
        for(int i=1; i<n; i++) {
            cost[i][0]+=Math.min(cost[i-1][1],cost[i-1][2]);
            cost[i][1]+=Math.min(cost[i-1][0],cost[i-1][2]);
            cost[i][2]+=Math.min(cost[i-1][0],cost[i-1][1]);
        }
        System.out.println(Math.min(Math.min(cost[n-1][0],cost[n-1][1]),cost[n-1][2]));
    }
}
