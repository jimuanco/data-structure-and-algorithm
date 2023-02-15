package Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//크게 만들기
public class Ex2812_timeLimitExceeded3 {
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
        String answer="";
        int idx=0;
        while(k<n) {
            int max=0;
            for(int i=idx; i<=k; i++) {
                if(arr[i]>max) {
                    max=arr[i];
                    idx=i;
                }
            }
            answer+=arr[idx];
            idx++;
            k++;
        }
        System.out.println(answer);
    }
}
