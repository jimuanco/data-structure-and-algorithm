package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

//랩실에서 잘 자요
public class Ex27446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        TreeSet<Integer> set = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            if(!set.contains(i)) arr.add(i);
        }
        //1 1
        //1
        //이 경우 위해
        if(arr.size()==0) {
            System.out.println(0);
            System.exit(0);
        }
        int answer=7; //잃어버린 첫번째 페이지 인쇄
        for(int i=1; i<arr.size(); i++) {
            int tmp=arr.get(i)-arr.get(i-1);
            if(tmp<4) answer+=2*(tmp); //4미만 차이 일 경우 연속 인쇄
            else answer+=7; //4이상 차이 일 경우
        }
        System.out.println(answer);
    }
}