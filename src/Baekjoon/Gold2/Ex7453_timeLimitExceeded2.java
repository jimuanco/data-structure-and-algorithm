package Baekjoon.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//합이 0인 네 정수
public class Ex7453_timeLimitExceeded2 {
    public static int lowerBond(ArrayList<Integer> arr, int target) {
        int lt=0;
        int rt=arr.size()-1;
        while(lt<rt) {
            int mid=(lt+rt)/2;
            if(arr.get(mid)<target) lt=mid+1;
            else rt=mid;
        }
        return lt;
    }
    public static int upperBond(ArrayList<Integer> arr, int target) {
        int lt=0;
        int rt=arr.size()-1;
        while(lt<rt) {
            int mid=(lt+rt)/2;
            if(arr.get(mid)<=target) lt=mid+1;
            else rt=mid;
        }
        return lt;
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
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr1.add(arrA[i]+arrB[j]);
                arr2.add(arrC[i]+arrD[j]);
            }
        }
        Collections.sort(arr2);
        int answer=0;
        for(int i=0; i<arr1.size(); i++) {
            int upper=upperBond(arr2,-arr1.get(i));
            int lower=lowerBond(arr2,-arr1.get(i));
            answer+=upper-lower;
        }
        System.out.println(answer);
    }
}
