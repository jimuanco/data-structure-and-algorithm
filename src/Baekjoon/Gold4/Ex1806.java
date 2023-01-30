package Baekjoon.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//부분합
//(주의)합이 S가 아니라 S 이상이 되는 것!
public class Ex1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int answer=Integer.MAX_VALUE, lt=0, sum=0;
        for(int rt=0; rt<n; rt++) {
            sum+=arr[rt];
            if(sum>=s) {
                answer = Math.min(rt - lt + 1, answer);
                while(sum>=s) {
                    sum-=arr[lt++];
                    if(sum>=s) answer=Math.min(rt-lt+1,answer);
                }
            }
        }
        if(answer==Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);
    }
}
