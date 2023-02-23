package Baekjoon.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//좋은 구간
public class Ex1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l=Integer.parseInt(br.readLine());
        int[] arr = new int[l];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<l; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int n=Integer.parseInt(br.readLine());
        int s=Integer.MIN_VALUE, e=0;
        for(int i=0; i<l; i++) {
            if(arr[i]==n) {
                System.out.println(0);
                return;
            }
            if(arr[i]<n) {
                s=arr[i]+1;
            }
            if(s!=Integer.MIN_VALUE && arr[i]>n) {
                e=arr[i]-1;
                break;
            }
        }
        //n<arr[0]일 수 있음 <- 1 ≤ n ≤ (집합 S에서 가장 큰 정수)
        if(s==Integer.MIN_VALUE) {
            s=1;
            e=arr[0]-1;
        }
        int answer=0;
        for(int i=s; i<=n; i++) {
            answer+=e-n+1;
        }
        System.out.println(answer-1);
    }
}
