package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//표절
//N이 100,000 -> 자료형 제발 주의 하자!
public class Ex2428 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long answer=0; //자료형 주의!
        for(int i=0; i<n-1; i++) {
            int lt=i+1;
            int rt=n-1;
            int cnt=0;
            while(lt<=rt) {
                int mid=(lt+rt)/2;
                if(arr[i]>=arr[mid]*0.9) {
                    cnt=mid-i;
                    lt=mid+1;
                } else {
                    rt=mid-1;
                }
            }
            answer+=cnt;
        }
        System.out.println(answer);
    }
}

//정렬
//이분 탐색
//슬라이딩 윈도우