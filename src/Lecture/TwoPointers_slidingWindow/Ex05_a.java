package Lecture.TwoPointers_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//연속된 자연수의 합
//수학적으로 풀 수도 있음
public class Ex05_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
//        int[] arr = new int[n+1];
//        for(int i=1; i<=n; i++) {
//            arr[i]=i;
//        }
        int answer=0, lt=1, sum=0;
        for(int rt=1; rt<=n/2+1; rt++) {
            sum+=rt;
            if(sum==n) answer++;
            while(sum>=n) {
                sum-=lt++;
                if(sum==n) answer++;
            }
        }
        System.out.println(answer);
    }
}
