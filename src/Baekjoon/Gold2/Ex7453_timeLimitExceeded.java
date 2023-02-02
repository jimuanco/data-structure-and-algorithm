package Baekjoon.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//합이 0인 네 정수
public class Ex7453_timeLimitExceeded {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arrA=new int[n];
        int[] arrB=new int[n];
        int[] arrC=new int[n];
        int[] arrD=new int[n];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arrA[i]=Integer.parseInt(st.nextToken());
            arrB[i]=Integer.parseInt(st.nextToken());
            arrC[i]=Integer.parseInt(st.nextToken());
            arrD[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        Arrays.sort(arrC);
        Arrays.sort(arrD);
        int answer=0, rt1=n-1,rt2=n-1,rt3=n-1;
        for(int i=0; i<n; i++) {
            boolean flag2=false;
            for(int j=rt3; j>=0; j--) {
                boolean flag1=false;
                if(flag2) break;
                for(int k=rt1; k>=0; k--) {
                    if(flag1) break;
                    if(flag2) break;
                    for(int l=rt2; l>=0; l--) {
                        int sum=arrA[i]+arrB[j]+arrC[k]+arrD[l];
                        if(sum<0 && k==n-1 && l==n-1) {
                            flag2=true;
                            break;
                        }
                        if(sum<0 && l==n-1) {
                            flag1=true;
                            break;
                        }
                        if(sum<0) {
                            break;
                        }
                        if(sum==0) answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
