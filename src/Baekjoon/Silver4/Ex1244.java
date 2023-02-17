package Baekjoon.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//스위치 켜고 끄기
public class Ex1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int m=Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            int cnt=1;
            if(s==1) {
                while(p*cnt<=n) {
                    if(arr[p*cnt]==1) arr[p*cnt]=0;
                    else arr[p*cnt]=1;
                    cnt++;
                }
            } else {
                if(arr[p]==1) arr[p]=0;
                else arr[p]=1;
                while(p-cnt>0 && p+cnt<=n && arr[p-cnt]==arr[p+cnt]) {
                    if(arr[p-cnt]==1) {
                        arr[p-cnt]=0;
                        arr[p+cnt]=0;
                    } else {
                        arr[p-cnt]=1;
                        arr[p+cnt]=1;
                    }
                    cnt++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            if(i!=1 && i%20==1) sb.append("\n");
            sb.append(arr[i]+" ");
        }
        System.out.println(sb);
    }
}
