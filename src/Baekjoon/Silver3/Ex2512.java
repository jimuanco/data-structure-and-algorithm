package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//예산
/*
2
10 20
12
 */
/*
2
10 20
20
 */
//2번처럼 풀어야 함
//lt, rt범위 잘 잡기!
public class Ex2512 {
    static int getTotalBudget(int budget, int[] arr) {
        int sum=0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]<=budget) {
                sum+=arr[i];
            } else {
                sum+=budget;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int lt=arr[0], rt=arr[n-1], answer=0;
        //lt=arr[0]으로 잡으면 m(총액)을 n(지방수)로 나눴을때 예산요청액중 가장 작은 값보다 작다면 나눈값으로 전부 분배해야 함(제목 테스트케이스 참조)
        //이 if문을 안쓸려면 lt=0으로 잡아야 됨(2번 풀이)
        if(m/n < arr[0]) {
            System.out.println(m/n);
            return;
        }
        while(lt<=rt) {
            int mid=(lt+rt)/2;
            if(getTotalBudget(mid,arr)<=m) {
                lt=mid+1;
                answer=mid;
            } else {
                rt=mid-1;
            }
        }
        System.out.println(answer);
    }
}
