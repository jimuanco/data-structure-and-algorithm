package Baekjoon.Gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//냅색문제
//N은 30이라 반으로 나눠서 따진다
//Baekjoon Ex1208(부분수열의 합2)와 비교
//여기선 C보다 무게가 작으면 담을 수 있기때문에 while문을 Ex1208처럼 쓸 순 없다
//for문 + upperBond 사용
//answer를 long으로 안해도 됨
public class Ex1450_a {
    static int[] arr;
    static int c;
    static int answer=0;
    static ArrayList<Integer> arr2,arr3;
    static void getSumSubSeq(int idx, int end, int sum, ArrayList<Integer> arrList, int cnt) {
        if(sum>c) { //이거 없으면 틀렸다고 뜸..(시간 초과로 떠야하는거 아닌가?)
            return;
        }
        if(idx==end) {
            if(sum<=c) {
                arrList.add(sum);
            }
        } else {
            getSumSubSeq(idx+1,end,sum+arr[idx],arrList,cnt+1);
            getSumSubSeq(idx+1,end,sum,arrList,cnt);
        }
    }

    static int upperBond(ArrayList<Integer> arr, int target) {
        int lt=0, rt=arr.size()-1;
        while(lt<=rt) {
            int mid=(lt+rt)/2;
            if(arr.get(mid)>target) rt=mid-1;
            else lt=mid+1;
        }
        return rt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        arr2 = new ArrayList<>();
        arr3 = new ArrayList<>();
        getSumSubSeq(0,n/2,0,arr2,0);
        getSumSubSeq(n/2,n,0,arr3,0);
        Collections.sort(arr2);
        for(int i=0; i<arr3.size(); i++) {
            int upper=upperBond(arr2,c-arr3.get(i));
            answer+=upper+1;
        }
        System.out.println(answer);
    }
}
