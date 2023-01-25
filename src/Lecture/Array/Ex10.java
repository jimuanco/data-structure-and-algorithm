package Lecture.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//봉우리
public class Ex10 {

    public int solution(int n, int[][] arr) {
        int answer = 0, me = 0, max = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                me = arr[i][j];
                if(j-1 >= 0) {
                    if(me <= arr[i][j-1]) {
                        continue;
                    }
                }
                if(j+1 < n) {
                    if(me <= arr[i][j+1]) {
                        continue;
                    }
                }
                if(i-1 >= 0) {
                    if(me <= arr[i-1][j]) {
                        continue;
                    }
                }
                if(i+1 < n) {
                    if(me <= arr[i+1][j]) {
                        continue;
                    }
                }
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex10 T = new Ex10();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(T.solution(n, arr));
        br.close();
    }
}
