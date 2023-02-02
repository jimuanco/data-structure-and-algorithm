package Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//나무 자르기
//자료형 주의!
public class Ex2805 {
    public static long getTree(int[] arr, int height) {
        long sum=0; //주의!
        for(int i=0; i<arr.length; i++) {
            if(arr[i]>height) {
                sum+=arr[i]-height;
            }
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int answer=0, lt=0, rt=arr[n-1];
        while(lt<=rt) {
            int mid=(lt+rt)/2;
            if(getTree(arr,mid)>=m) {
                answer=mid;
                lt=mid+1;
            } else rt=mid-1;
        }
        System.out.println(answer);
    }
}
