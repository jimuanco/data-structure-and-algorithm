package Lecture.TwoPointers_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//최대 길이 연속부분수열
public class Ex06_a {
    public int solution(int n, int k, int[] arr) {
        int answer = 0, cnt=0, lt=0;
        for(int rt=0; rt<n; rt++) {
            if(arr[rt]==0) cnt++;
            while(cnt>k) {
                if(arr[lt]==0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt -lt +1);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex06_a T = new Ex06_a();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(n, m, arr));
    }
}
