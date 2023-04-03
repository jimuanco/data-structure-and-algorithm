package Baekjoon.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//올바른 배열
public class Ex1337 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int max=0;
        for(int i=0; i<n; i++) {
            int rt=i, num=0, cnt=0;
            while(rt<n && arr[rt]<=arr[i]+4) {
                if(arr[rt]==arr[i]+num++) {
                    rt++;
                    cnt++;
                }
            }
            max=Math.max(max,cnt);
        }
        System.out.println(5-max);
    }
}
