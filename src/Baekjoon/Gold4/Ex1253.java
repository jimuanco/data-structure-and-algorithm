package Baekjoon.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//좋다
public class Ex1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int answer=0;
        for(int i=0; i<n; i++) { //좋은 수 후보들
            int lt=0,rt=arr.length-1;
            while(lt<rt) {
                if(lt==i) { //좋은 수 자신이 합한수 중 하나로 쓰이면 안됨
                    lt++;
                    continue;
                }
                if(rt==i) { //좋은 수 자신이 합한수 중 하나로 쓰이면 안됨
                    rt--;
                    continue;
                }
                int sum=arr[lt]+arr[rt];
                if(sum<arr[i]) {
                    lt++;
                } else if(sum>arr[i]) {
                    rt--;
                } else {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
