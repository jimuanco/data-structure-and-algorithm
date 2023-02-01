package Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//두 용액
public class Ex2470_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        ArrayList<Integer> answer = new ArrayList<>();
        int lt=0, rt=arr.length-1, minV=Integer.MAX_VALUE, sol1=0, sol2=0;
        while(lt<rt) {
            int sum=arr[lt]+arr[rt];
            if(Math.abs(sum)<minV) {
                sol1=arr[lt];
                sol2=arr[rt];
                if(sum==0) {
                    break;
                }
                minV=Math.abs(sum);
            }
            if(sum<0) lt++;
            else rt--;
        }
        answer.add(sol1);
        answer.add(sol2);
        StringBuilder sb = new StringBuilder();
        for(int x : answer) {
            sb.append(x+" ");
        }
        System.out.println(sb);
    }
}
