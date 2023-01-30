package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//두 수의 합
//Ex1940(주몽) 같은 유형
public class Ex3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int x=Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int answer=0, lt=0, rt=arr.length-1;
        while(lt<rt) {
            for(int i=rt; i>lt; i--) {
                int sum=arr[lt]+arr[i];
                if(sum<x) {
                    rt=i;
                    break;
                } else if(sum==x) {
                    answer++;
                    rt=i-1;
                    break;
                }
            }
            lt++;
        }
        System.out.println(answer);
    }
}
