package Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//가장높은탑쌓기
//Lecture.DP Ex04(가장 높은 탑 쌓기(LIS 응용))보다 어려운 문제
class Brick implements Comparable<Brick> {
    int n,s,h,w;
    Brick(int n, int s, int h, int w) {
        this.n=n;
        this.s=s;
        this.h=h;
        this.w=w;
    }
    @Override
    public int compareTo(Brick ob) {
        return ob.s-this.s;
    }
}

public class Ex2655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Brick> arr = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.add(new Brick(i+1,s,h,w));
        }
        Collections.sort(arr);
        int[] dp = new int[n];
        dp[0]=arr.get(0).h;
        int height=dp[0], top=0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=1; i<n; i++) {
            int max_h=0;
            for(int j=i-1; j>=0; j--) {
                if(arr.get(i).w<arr.get(j).w && dp[j]>max_h) {
                    max_h=dp[j];
                }
            }
            dp[i]=max_h+arr.get(i).h;
            if(height<dp[i]) {
                height=dp[i]; //가장 높이 쌓았을 때 높이
                top=i; //탑의 가장 위에 벽돌 인덱스(정렬 후)
            }
        }
        result.add(arr.get(top).n); //탑 가장 위 벽돌 번호
        int idx=top;
        for(int i=top-1; i>=0; i--) { //탑 가장 위 벽돌 아래 벽돌부터 벽돌 번호를 result.add
            if(height-arr.get(idx).h==dp[i] && arr.get(idx).w<arr.get(i).w) {
                result.add(arr.get(i).n);
                height=dp[i];
                idx=i;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()+"\n");
        for(int x : result) {
            sb.append(x+"\n");
        }
        System.out.println(sb);
    }
}
