package Lecture.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//최대 부분 증가수열(LIS)
public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] dy=new int[n];
        dy[0]=1;
        int answer=dy[0]; //n이 1일 경우
        for(int i=1;i<n;i++) {
            int max=0;
            for(int j=i-1; j>=0; j--) {
                if(arr[j]<arr[i] && dy[j]>max) max=dy[j];
            }
            dy[i]=max+1;
            answer=Math.max(answer,dy[i]);
        }
        System.out.println(answer);
    }
}
