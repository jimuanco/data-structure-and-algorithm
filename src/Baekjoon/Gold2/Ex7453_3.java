package Baekjoon.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//합이 0인 네 정수
//투 포인터로 풀기 -> 이 풀이가 이분탐색으로 푼것보다 훨씬 빠름
//Baekjoon Ex1208(부분수열의 합2)와 같이 중간에서 만나기(Meet in the Middle, MITM) 사용
//2의 코드도 정답은 맞으나 이렇게 풀기 -> Baekjoon Ex1208(부분수열의 합2) 참고
public class Ex7453_3 {
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
                long leftCount=0, rightCount=0; //자료형 long
                int a=arr1[lt];
                while(lt<n*n && arr1[lt]==a) {
                    leftCount++;
                    lt++;
                }
                int b=arr2[rt];
                while(rt>=0 && arr2[rt]==b) {
                    rightCount++;
                    rt--;
                }
                answer+=leftCount*rightCount;
            }
        }
        System.out.println(answer);
    }
}

//정렬
//이분 탐색
//두 포인터
//중간에서 만나기