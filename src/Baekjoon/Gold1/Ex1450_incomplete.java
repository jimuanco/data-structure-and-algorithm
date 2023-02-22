package Baekjoon.Gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//냅색문제
public class Ex1450_incomplete {
    static int[] arr;
    static int c;
    static long answer=0;
    static ArrayList<Integer> arr2,arr3;
    static void getSumSubSeq(int idx, int end, int sum, ArrayList<Integer> arrList, int cnt) {
        if(idx==end) {
            if(sum<=c) {
                arrList.add(sum);
//                answer+=1;
            }
        } else {
            getSumSubSeq(idx+1,end,sum+arr[idx],arrList,cnt+1);
            getSumSubSeq(idx+1,end,sum,arrList,cnt);
        }
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
        Collections.sort(arr3);
        int lt=0;
        int rt=arr3.size()-1;
        long cnt1=0,cnt2=0;
        while(lt<arr2.size() && rt>=0) {
            int sum=arr2.get(lt)+arr3.get(rt);
            if(sum<=c) {
                int a=arr2.get(lt);
                while(lt<arr2.size() && arr2.get(lt)==a) {
                    cnt1++;
                    lt++;
                }
                int b=arr3.get(rt);
                while(rt>=0 && arr3.get(rt)==b) {
                    cnt2++;
                    rt--;
                }
            } else {
                rt--;
            }
        }
        answer+=cnt1*cnt2;
        System.out.println(answer);
    }
}
