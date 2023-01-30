package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//겹치는 건 싫어
public class Ex20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int answer=0, lt=0;
        for(int rt=0; rt<n; rt++) {
            map.put(arr[rt],map.getOrDefault(arr[rt],0)+1);
            while(map.get(arr[rt])>k) {
                map.put(arr[lt],map.get(arr[lt])-1);
                lt++;
            }
            answer=Math.max(answer,rt-lt+1);
        }
        System.out.println(answer);
    }
}