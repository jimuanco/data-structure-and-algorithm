package Lecture.TwoPointers_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//최대 매출
public class Ex03 {

    public int solution(int n, int m, int[] a) {
        int answer = 0 ,sum = 0;
        for(int i=0; i<m; i++) {
            answer += a[i];
        }
        sum = answer;
        for(int i=1; i<n-m+1; i++) {
            sum += -a[i-1]+a[i+m-1];
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex03 T = new Ex03();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(n, m, a));
        br.close();
    }
}
