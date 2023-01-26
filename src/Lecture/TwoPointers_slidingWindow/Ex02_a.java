package Lecture.TwoPointers_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//공통원소 구하기
public class Ex02_a {

    public ArrayList<Integer> solution(int n, int[] a, int m, int[] b) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Arrays.sort(a);
        Arrays.sort(b);
        int p1=0, p2=0;
        while(p1<n && p2<m) {
            if(a[p1] == b[p2]) {
                answer.add(a[p1++]);
                p2++;
            }
            else if(a[p1] < b[p2]) p1++;
            else p2++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex02_a T = new Ex02_a();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] b = new int[m];
        for(int i=0; i<m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for(int x : T.solution(n ,a, m, b)) {
            sb.append(x+ " ");
        }
        System.out.print(sb);
        br.close();
    }
}
