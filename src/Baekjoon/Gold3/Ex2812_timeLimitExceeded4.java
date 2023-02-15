package Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//크게 만들기
//while문안에 for문 있으니 시간초과
public class Ex2812_timeLimitExceeded4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        String input = br.readLine();
        char[] ch = input.toCharArray();
        for(int i=0; i<n; i++) {
            arr[i]=ch[i]-'0'; //주의 !! +'0'하면 안돼
        }
        ArrayList<Integer> answer = new ArrayList<>();
        int idx=0;
        while(k<n) {
            int max=0;
            for(int i=idx; i<=k; i++) {
                if(arr[i]>max) {
                    max=arr[i];
                    idx=i;
                }
            }
            answer.add(arr[idx]);
            idx++;
            k++;
        }
        StringBuilder sb = new StringBuilder();
        for(int x : answer) {
            sb.append(x);
        }
        System.out.println(sb);
    }
}
