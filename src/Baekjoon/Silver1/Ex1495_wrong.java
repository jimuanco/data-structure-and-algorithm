package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//기타리스트
//2차원 배열 써야함
//반례 ->
//2 1 4
//1 2
public class Ex1495_wrong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] dy=new int[m+1];
        if(s+arr[0]<=m) dy[s+arr[0]]=1;
        if(s-arr[0]>=0) dy[s-arr[0]]=1;
        int cnt=1;
        for(int i=1; i<n; i++) {
            for(int j=0; j<=m; j++) {
                if(dy[j]==cnt) {
                    dy[j]=0;
                    if(j+arr[i]<=m) dy[j+arr[i]]=cnt+1;
                    if(j-arr[i]>=0) dy[j-arr[i]]=cnt+1;
                }
            }
            cnt++;
        }
        int answer=Integer.MIN_VALUE;
        for(int i=m; i>=0; i--) {
            if(dy[i]==cnt) {
                answer=Math.max(answer,i);
                break;
            }
        }
        if(answer!=Integer.MIN_VALUE) System.out.println(answer);
        else System.out.println(-1);
    }
}
