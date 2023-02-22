package Baekjoon.Gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//부분수열의 합2
public class Ex1208_wrong {
    static int[] arr1,arr2;
    static ArrayList<Integer> arr3,arr4;
    static void getSumSubSeq(int L, int sum, int m, int[] arr, ArrayList<Integer> arr2) {
        if(L==m) {
            arr2.add(sum);
        } else {
            getSumSubSeq(L+1,sum+arr[L],m,arr,arr2);
            getSumSubSeq(L+1,sum,m,arr,arr2);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());
        arr1 = new int[n/2];
        arr2 = new int[n-n/2];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n/2; i++) {
            arr1[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n-n/2; i++) {
            arr2[i]=Integer.parseInt(st.nextToken());
        }
        arr3= new ArrayList<>();
        arr4= new ArrayList<>();
        getSumSubSeq(0,0,n/2,arr1,arr3);
        getSumSubSeq(0,0,n-n/2,arr2,arr4);
        Collections.sort(arr3);
        Collections.sort(arr4);
        int lt=0, rt=arr4.size()-1;
        long answer=0;
        while(lt<arr3.size() && rt>=0) {
            int sum=arr3.get(lt)+arr4.get(rt);
            if(sum<s) {
                lt++;
            } else if(sum>s) {
                rt--;
            } else {
                int cnt1=1,cnt2=1;
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
