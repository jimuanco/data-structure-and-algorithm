package Lecture.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//가장 높은 탑 쌓기(LIS 응용)
//Baekjoon Ex2655(가장높은탑쌓기)가 더 어려움
class Brick implements Comparable<Brick> {
    public int s,h,w;
    Brick(int s, int h, int w) {
        this.s=s;
        this.h=h;
        this.w=w;
    }
    @Override
    public int compareTo(Brick o) {
        return o.s-this.s;
    }
}

public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Brick> arr = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new Brick(a,b,c));

        }
        Collections.sort(arr);
        int[] dy=new int[n];
        dy[0]=arr.get(0).h;
        int answer=dy[0]; //n이 1일 경우
        for(int i=1; i<n; i++){
            int max_h=0;
            for(int j=i-1; j>=0; j--) {
                if(arr.get(j).w>arr.get(i).w && dy[j]>max_h) {
                    max_h=dy[j];
                }
            }
            dy[i]=max_h+arr.get(i).h;
            answer=Math.max(answer,dy[i]);
        }
        System.out.println(answer);
    }
}
