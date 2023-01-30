package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//수열
public class Ex2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int answer=Integer.MIN_VALUE, sum=0, lt=0;
        for(int i=0; i<k-1; i++) {
            sum+=arr[i];
        }
        for(int rt=k-1; rt<n; rt++) {
            sum+=arr[rt];
            answer=Math.max(answer,sum);
            sum-=arr[lt++];
        }
        System.out.println(answer);
    }
}
