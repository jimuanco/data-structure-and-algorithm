package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//게으른 백곰
public class Ex10025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Integer[][] arr = new Integer[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1, o2) -> (o1[1]-o2[1]));
        int rt=0;
        long sum=0, max=0;
        for(int i=arr[0][1]; i<arr[0][1]+k; i++) {
            if(rt<arr.length && i==arr[rt][1]) {
                sum+=arr[rt++][0];
            }
            max=Math.max(max,sum);
        }
        int lt=0;
        for(int i=arr[0][1]+k; i<=arr[n-1][1]; i++) {
            if(i-2*k==arr[lt][1]+1) {
                sum-=arr[lt++][0];
            }
            if(rt<arr.length && i == arr[rt][1]) {
                sum+=arr[rt++][0];
            }
            max=Math.max(max,sum);
        }
        System.out.println(max);
    }
}
