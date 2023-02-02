package Baekjoon.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//합이 0인 네 정수
//이분탐색을 이용한 이 풀이는 제출했을 때 시간초과 뜰때도 있음
public class Ex7453_a {
    //lower_bond , upper_bond -> {13,13,15,17,17,17,17,20,20} 배열로 따져보기
    public static int lowerBond(int[] arr, int target) { //특정 target보다 크거나 같은 첫번째 원소의 인덱스를 리턴(이거보다 1작게 리턴)
        int lt=0;
        int rt=arr.length-1;
        while(lt<=rt) {
            int mid=(lt+rt)/2;
            if(arr[mid]>=target) rt=mid-1;
            else lt=mid+1;
        }
        return rt;
    }
    public static int upperBond(int[] arr, int target) { //특정 target보다 큰 첫번째 원소의 인덱스를 리턴(이거보다 1작게 리턴)
        int lt=0;
        int rt=arr.length-1;
        while(lt<=rt) {
            int mid=(lt+rt)/2;
            if(arr[mid]>target) rt=mid-1;
            else lt=mid+1;
        }
        return rt;
    }
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
                arr2[cnt]=arrC[i]+arrD[j];
                cnt++;
            }
        }
        Arrays.sort(arr2);
        long answer=0; //4,000 ^ 4 가 최댓값이므로 long 형태
        for(int i=0; i<arr1.length; i++) {
            int upper=upperBond(arr2,-arr1[i]);
            int lower=lowerBond(arr2,-arr1[i]);
            answer+=upper-lower;
        }
        System.out.println(answer);
    }
}
