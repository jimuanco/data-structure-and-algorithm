package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//주유소
//자료형 주의!!
//wrong 코드와 비교해서 차이점 숙지
public class Ex13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] price=new int[n-1]; //여기는 int되네
        int[] dis=new int[n-1]; //여기는 int되네
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++) {
            dis[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++) {
            price[i]=Integer.parseInt(st.nextToken());
        }
        long answer=0, minP=Integer.MAX_VALUE; //자료형 주의!!
        for(int i=0; i<n-1; i++) {
            minP=Math.min(minP,price[i]);
            answer+=minP*dis[i];
        }
        System.out.println(answer);
    }
}
