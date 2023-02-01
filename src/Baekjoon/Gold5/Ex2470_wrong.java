package Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//두 용액
public class Ex2470_wrong {
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
        int mid=0;
        for(int i=0; i<n; i++) {
            if(arr[i]>0) {
                mid=i;
                break;
            }
            mid=-1;
        }
        int rt=arr.length-1,lt=0,feature=Integer.MAX_VALUE, sol1=0, sol2=0;
        boolean flag=false;
        while(lt<rt && mid!=0 && mid!=-1) {
            for(int i=rt; i>lt; i--) {
                if(Math.abs(arr[lt])>Math.abs(arr[rt])) {
//                    feature=Math.min(Math.abs(arr[lt]+arr[rt]),feature);
                    if(feature>Math.abs(arr[lt]+arr[rt])) {
                        sol1=arr[lt];
                        sol2=arr[rt];
                        feature=Math.abs(arr[lt]+arr[rt]);
                    }
                    rt=i-1;
                    break;
                } else if(Math.abs(arr[lt])<Math.abs(arr[rt])) {
//                    feature=Math.min(Math.abs(arr[lt]+arr[rt]),feature);
                    if(feature>Math.abs(arr[lt]+arr[rt])) {
                        sol1=arr[lt];
                        sol2=arr[rt];
                        feature=Math.abs(arr[lt]+arr[rt]);
                    }
                    if(Math.abs(arr[lt])>Math.abs(arr[rt])) break;
                } else {
                    sol1=arr[lt];
                    sol2=arr[rt];
                    flag=true;
                }
            }
            if(flag) break;
            lt++;
        }
        if(mid==0) {
            answer.add(arr[0]);
            answer.add(arr[1]);
        }
        if(mid==-1) {
            answer.add(arr[arr.length-1]);
            answer.add(arr[arr.length-2]);
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
