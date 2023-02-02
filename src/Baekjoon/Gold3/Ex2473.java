package Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//세 용액
//자료형 주의!
public class Ex2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long[] arr=new long[n]; //주의!
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Long.parseLong(st.nextToken()); //주의!
        }
        Arrays.sort(arr);
        ArrayList<Long> answer = new ArrayList<>();
        long minV=Long.MAX_VALUE, sol1=0, sol2=0, sol3=0;
        boolean flag=false;
        for(int i=0; i<n; i++) {
            int lt=0, rt=n-1;
            if(flag) break;
            while(lt<rt) {
                if(lt==i) {
                    lt++;
                    continue;
                }
                if(rt==i) {
                    rt--;
                    continue;
                }
                long sum=arr[i]+arr[lt]+arr[rt];
                if(Math.abs(sum)<minV) {
                    sol1=arr[i];
                    sol2=arr[lt];
                    sol3=arr[rt];
                    if(sum==0) {
                        flag=true;
                        break;
                    }
                    minV=Math.abs(sum);
                }
                if(sum<0) lt++;
                else rt--;
            }
        }
        answer.add(sol1);
        answer.add(sol2);
        answer.add(sol3);
//        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for(long x : answer) {
            sb.append(x+" ");
        }
        System.out.println(sb);
    }
}
