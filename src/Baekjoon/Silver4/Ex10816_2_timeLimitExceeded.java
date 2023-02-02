package Baekjoon.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//숫자 카드2
//이분탐색인데 시간초과
public class Ex10816_2_timeLimitExceeded {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr1=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr1[i]=Integer.parseInt(st.nextToken());
        }
        int m=Integer.parseInt(br.readLine());
        int[] arr2=new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            arr2[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);
        ArrayList<Integer> answer=new ArrayList<>();
        for(int i=0; i<m; i++) {
            boolean flag=false;
            int lt=0, rt=n-1, cnt=0;
            while(lt<=rt) {
                int mid=(lt+rt)/2;
                if(arr2[i]==arr1[mid]) {
                    cnt++;
                    int tmp=mid;
                    while(tmp<n-1 && arr1[tmp]==arr1[tmp+1]) {
                        cnt++;
                        tmp++;
                    }
                    tmp=mid;
                    while(tmp>0 && arr1[tmp]==arr1[tmp-1]) {
                        cnt++;
                        tmp--;
                    }
                    flag=true;
                    break;
                }
                if(arr2[i]>arr1[mid]) lt=mid+1;
                else rt=mid-1;
            }
            if(!flag) answer.add(0);
            else answer.add(cnt);
        }
        StringBuilder sb = new StringBuilder();
        for(int x : answer) {
            sb.append(x+" ");
        }
        System.out.println(sb);
    }
}
