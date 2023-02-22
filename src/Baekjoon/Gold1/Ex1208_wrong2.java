package Baekjoon.Gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//부분수열의 합2
public class Ex1208_wrong2 {
    static long[] arr;
    static ArrayList<Long> arr3,arr4;
    static void getSumSubSeq(int L, int end, long sum, ArrayList<Long> arr2) {
        if(L==end) {
            arr2.add(sum);
        } else {
            getSumSubSeq(L+1,end,sum+arr[L],arr2);
            getSumSubSeq(L+1,end,sum,arr2);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());
        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Long.parseLong(st.nextToken());
        }
        arr3= new ArrayList<>();
        arr4= new ArrayList<>();
        getSumSubSeq(0,n/2,0,arr3);
        getSumSubSeq(n/2,n,0,arr4);
        Collections.sort(arr3);
        Collections.sort(arr4);
        int lt=0, rt=arr4.size()-1;
        long answer=0;
        while(lt<arr3.size() && rt>=0) {
            long sum=arr3.get(lt)+arr4.get(rt);
            if(sum<s) {
                lt++;
            } else if(sum>s) {
                rt--;
            } else {
                long cnt1=1,cnt2=1;
                while(lt+1<arr3.size() && arr3.get(lt)==arr3.get(lt+1)) {
                    cnt1++;
                    lt++;
                }
                while(rt-1>=0 && arr4.get(rt)==arr4.get(rt-1)) {
                    cnt2++;
                    rt--;
                }
                answer+=cnt1*cnt2;
                lt++;
            }
        }
        if(s==0) answer--;
        System.out.println(answer);
    }
}
