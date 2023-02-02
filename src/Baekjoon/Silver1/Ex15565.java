package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//귀여운 라이언
public class Ex15565 {
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
        int answer=Integer.MAX_VALUE, lt=0, cnt=0, ch=2;
        for(int rt=0; rt<n; rt++) {
            if(arr[rt]==1) cnt++;
            if(cnt==k) {
                answer=Math.min(answer,rt-lt+1);
            }
            while(cnt>k) {
                if(arr[lt++]==1) cnt--;
                while(arr[lt]!=1) {
                    lt++;
                }
                answer=Math.min(answer,rt-lt+1);
            }
        }
        if(answer==Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
