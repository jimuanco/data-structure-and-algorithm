package Lecture.TwoPointers_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//풀이는 for문으로 풀었음 함 봐바
public class Ex04 {

    public int solution(int n, int m, int[] a) {
        int answer = 0, p1=0, p2=0, sum=0;
        while(p1<n && p2<n) {
            sum += a[p2];
            if(sum<m) {
                p2++;
            } else if(sum==m) {
                sum=0;
                p1++;
                p2=p1;
                answer++;
            } else {
                sum=0;
                p1++;
                p2=p1;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex04 T = new Ex04();
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
    }
}
