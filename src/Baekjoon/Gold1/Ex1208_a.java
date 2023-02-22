package Baekjoon.Gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//부분수열의 합2

//Baekjoon Ex7453(합이 0인 네 정수)와 같이 중간에서 만나기(Meet in the Middle, MITM) 사용
//자료형 주의(쓸데없이 long 남발시 메모리 많이 잡아먹음 따라서 필요한 곳에만!)
//wrong2가 왜 틀렸는지 모르겠음
//코드 차이점은 부분수열합의 배열 두개(arr3,arr4)의 원소 각각을 더한 값이 S랑 같을때 처리에서 차이남(이 코드는 lt++, rt--를 둘 다 해줌, wrong2는 lt++만)
//따라서 Baekjoon Ex7453(합이 0인 네 정수)도 이렇게 풀기

//Baekjoon Ex1182(부분수열의 합)에서 N값만 20->40
//따라서 재귀로 백트래킹으로 풀 수 없음
//배열을 두개로 나눠서 N을 반으로 나누고 중간에서 만나기 사용
public class Ex1208_a {
    static int[] arr;
    static ArrayList<Integer> arr3,arr4;
    static void getSumSubSeq(int L, int end, int sum, ArrayList<Integer> arr2) {
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
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        arr3= new ArrayList<>();
        arr4= new ArrayList<>();
        getSumSubSeq(0,n/2,0,arr3);
        getSumSubSeq(n/2,n,0,arr4);
        Collections.sort(arr3);
        Collections.sort(arr4);
        int lt=0, rt=arr4.size()-1;
        long answer=0; //자료형 주의!
        while(lt<arr3.size() && rt>=0) {
            int sum=arr3.get(lt)+arr4.get(rt);
            if(sum<s) {
                lt++;
            } else if(sum>s) {
                rt--;
            } else {
                long cnt1=0,cnt2=0; //자료형 주의!
                int a=arr3.get(lt);
                while(lt<arr3.size() && arr3.get(lt)==a) {
                    cnt1++;
                    lt++;
                }
                int b=arr4.get(rt);
                while(rt>=0 && arr4.get(rt)==b) {
                    cnt2++;
                    rt--;
                }
                answer+=cnt1*cnt2;
            }
        }
        if(s==0) answer--;
        System.out.println(answer);
    }
}
