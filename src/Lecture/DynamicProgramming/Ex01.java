package Lecture.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//계단오르기 -> bottom up
public class Ex01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] dy= new int[n+1];
        dy[1]=1;
        dy[2]=2;
        for(int i=3; i<=n; i++) {
            dy[i]=dy[i-2]+dy[i-1];
        }
        System.out.println(dy[n]);
    }
}
