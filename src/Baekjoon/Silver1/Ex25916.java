package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//싫은데요
public class Ex25916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int answer=0, sum=0, lt=0;
        for(int rt=0; rt<n; rt++) {
            sum+=arr[rt];
            if(sum<=m) answer=Math.max(answer,sum);
            while(sum>m) {
                sum-=arr[lt++];
                if(sum<=m) answer=Math.max(answer,sum);
            }
        }
        System.out.println(answer);
    }
}
