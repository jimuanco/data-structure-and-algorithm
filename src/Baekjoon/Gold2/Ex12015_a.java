package Baekjoon.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//가장 긴 증가하는 부분 수열 2
//'길이'를 구하는데 한정하여 이분탐색을 활용해 풀이 할 수 있음
public class Ex12015_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] lis = new int[n];
        // LIS 초기 값으로 첫 번째 수열의 값을 갖는다.
        lis[0]=arr[0];
        int lengthOfLis = 1;
        for(int i=1; i<n; i++) {
            int num=arr[i];
            // 만약 num이 lis의 마지막 값보다 클 경우 추가해준다.
            if(lis[lengthOfLis-1]<num) {
                lengthOfLis++;
                lis[lengthOfLis-1]=num;
            } else {
                // Lower Bound
                int lt=0;
                int rt=lengthOfLis-1;
                while(lt<=rt) {
                    int mid=(lt+rt)/2;
                    if(lis[mid]>=num) rt=mid-1;
                    else lt=mid+1;
                }
                /*
                rt+1이 lis에서 대치 될 원소의 위치가 될 것이고
                해당 위치에 num값으로 원소를 바꿔준다.
                 */
                lis[rt+1]=num;
            }
        }
        System.out.println(lengthOfLis);
    }
}
