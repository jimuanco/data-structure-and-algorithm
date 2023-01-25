package Lecture.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//큰 수 출력하기
public class Ex01_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> answer=new ArrayList<>();
        answer.add(arr[0]);
        for(int i=1; i<n;i++) {
            if(arr[i]>arr[i-1]) answer.add(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int x : answer) {
            sb.append(x+" ");
        }
        System.out.println(sb);
    }
}
