package Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//수 고르기
public class Ex2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int answer=Integer.MAX_VALUE, lt=0;
        for(int rt=1; rt<n; rt++) {
            int gap=arr[rt]-arr[lt];
            while(gap>=m && lt<rt) {
                answer=Math.min(answer,gap);
                lt++;
                gap=arr[rt]-arr[lt];
            }
        }
        System.out.println(answer);
    }
}
