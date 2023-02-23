package Baekjoon.Gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//제곱 ㄴㄴ 수
public class Ex1016_wrong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        long s=(long)Math.ceil(Math.sqrt(min));
        if(s==1) s=2;
        int[] arr= new int[(int)(max-min+1)];
        int cnt=0;
        long square=(long)Math.pow(s,2);
        for(long i=square; i<=max;) {
            if(arr[(int)(i-min)]==0) {
                for(long j=i; j<=max; j=j+i) {
                    if(arr[(int)(j-min)]==1) continue;
                    arr[(int)(j-min)]=1;
                    cnt++;
                }
            }
            s++;
            i=(long)Math.pow(s,2);
        }
        System.out.println((max-min+1)-cnt);
    }
}
