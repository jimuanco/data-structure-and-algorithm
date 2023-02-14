package Baekjoon.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//로프
//중량을 나눌수록 최대로 들 수 있는 중량이 증가할 수 있다.
public class Ex2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long max=0;
        int cnt=1;
        for(int i=n-1; i>=0; i--) {
            max=Math.max(max,arr[i]*cnt++);
        }
        System.out.println(max);
    }
}
