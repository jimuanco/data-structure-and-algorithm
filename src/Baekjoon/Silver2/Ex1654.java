package Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//랜선 자르기
//자료형 주의!
public class Ex1654 {
    public static long count(long[] arr, long len) {
        long cnt=0;
        for(int i=0; i<arr.length; i++) {
            cnt+=arr[i]/len;
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        long[] arr=new long[k];
        for(int i=0; i<k; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        long lt=1, answer=0; //0으로 나눌 수 없기 때문에 lt=1
        long rt= Arrays.stream(arr).max().getAsLong();
        while(lt<=rt) {
            long mid=(lt+rt)/2;
            if(count(arr,mid)>=n) {
                answer=mid;
                lt=mid+1;
            } else rt=mid-1;
        }
        System.out.println(answer);
    }
}
