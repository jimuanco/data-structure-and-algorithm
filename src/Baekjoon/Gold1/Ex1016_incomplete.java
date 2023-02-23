package Baekjoon.Gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//제곱 ㄴㄴ 수
//반례 1000000000000 1000001000000
//정답 607940
public class Ex1016_incomplete {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int[] arr= new int[(int)(max-min+1)];
        int cnt=0;
        for(long i=2; i<=max; i++) {
            long square=i*i;
            if(square-min>=0 && square<max && arr[(int)(square-min)]==0) {
                for(long j=square; j<=max; j=j*i) {
//                    if(arr[(int)(j-min)]==1) continue;
                    arr[(int)(j-min)]=1;
                    cnt++;
                }
            }
        }
        System.out.println((max-min+1)-cnt);
    }
}
