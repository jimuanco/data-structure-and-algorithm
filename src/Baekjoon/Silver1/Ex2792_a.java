package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//보석 상자
public class Ex2792_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        int lt=1, rt=0;
        for(int i=0; i<m; i++) {
            arr[i]=Integer.parseInt(br.readLine());
            rt=Math.max(rt,arr[i]);
        }
        int answer=0;
        while(lt<=rt) {
            int mid=(lt+rt)/2;
            int sum=0;
            for(int i=0; i<m; i++) {
                sum += arr[i]/mid;
                if(arr[i] % mid != 0) {
                    sum++;
                }
            }
            if(sum<=n) {
                answer=mid;
                rt=mid-1;
            } else {
                lt=mid+1;
            }
        }
        System.out.println(answer);
    }
}
