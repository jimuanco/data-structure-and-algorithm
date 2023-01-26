package Lecture.TwoPointers_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//두 배열 합치기
public class Ex01_a {

    public ArrayList<Integer> solution(int n, int[] arr1, int m, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int p1=0, p2=0;
        while(p1<n && p2<m) {
            if(arr1[p1]<arr2[p2]) answer.add(arr1[p1++]);
            else answer.add(arr2[p2++]);
        }
        while(p1<n) answer.add(arr1[p1++]);
        while(p2<m) answer.add(arr2[p2++]);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex01_a T = new Ex01_a();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr1 = new int[n];
        for(int i=0; i<n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[m];
        for(int i=0; i<m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int x : T.solution(n, arr1, m, arr2)) {
            sb.append(x + " ");
        }
        System.out.print(sb);
        br.close();
    }
}
