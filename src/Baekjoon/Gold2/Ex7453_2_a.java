package Baekjoon.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//합이 0인 네 정수
//투 포인터로 풀기 -> 이 풀이가 이분탐색으로 푼것보다 훨씬 빠름
public class Ex7453_2_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arrA=new int[n];
        int[] arrB=new int[n];
        int[] arrC=new int[n];
        int[] arrD=new int[n];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arrA[i]=Integer.parseInt(st.nextToken());
            arrB[i]=Integer.parseInt(st.nextToken());
            arrC[i]=Integer.parseInt(st.nextToken());
            arrD[i]=Integer.parseInt(st.nextToken());
        }
        int[] arr1=new int[n*n];
        int[] arr2=new int[n*n];
        int cnt=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr1[cnt]=arrA[i]+arrB[j];
                arr2[cnt++]=arrC[i]+arrD[j];
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        long answer=0; //4,000 ^ 4 가 최댓값이므로 long 형태
        int lt=0,rt=n*n-1;
        while(lt<n*n && rt>=0) {
            if(arr1[lt]+arr2[rt]<0) {
                lt++;
            } else if(arr1[lt]+arr2[rt]>0) {
                rt--;
            } else {
                long leftCount=1, rightCount=1; //자료형 long
                while(lt+1<n*n && arr1[lt]==arr1[lt+1]) {
                    leftCount++;
                    lt++;
                }
                while(rt>0 && arr2[rt]==arr2[rt-1]) {
                    rightCount++;
                    rt--;
                }
                answer+=leftCount*rightCount;
                lt++;
            }
        }
        System.out.println(answer);
    }
}
