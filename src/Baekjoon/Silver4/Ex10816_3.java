package Baekjoon.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//숫자 카드2
//HashMap으로 푸는거보다 메모리는 적게 쓰나 시간은 조금 더 걸림
public class Ex10816_3 {
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
            int upper=upperBond(arr1,arr2[i]);
            int lower=lowerBond(arr1,arr2[i]);
            answer.add(upper-lower);
        }
        StringBuilder sb= new StringBuilder();
        for(int x : answer) {
            sb.append(x+" ");
        }
        System.out.println(sb);
    }
}
