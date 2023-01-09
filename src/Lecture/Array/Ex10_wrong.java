package Lecture.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//상하좌우값과 같아도 봉우리가 아닌 조건을 뺴먹어서 그런듯?
public class Ex10_wrong {

    public int solution(int n, int[][] arr) {
        int answer = 0, me = 0, max = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                me = arr[i][j];
                max = arr[i][j];
                if(j-1 >= 0) {
                    max = Math.max(max, arr[i][j-1]);
                }
                if(j+1 < n) {
                    max = Math.max(max, arr[i][j+1]);
                }
                if(i-1 >= 0) {
                    max = Math.max(max, arr[i-1][j]);
                }
                if(i+1 < n) {
                    max = Math.max(max, arr[i+1][j]);
                }
                if(me == max) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex10_wrong T = new Ex10_wrong();
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
