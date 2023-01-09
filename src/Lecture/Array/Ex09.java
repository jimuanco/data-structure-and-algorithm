package Lecture.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//풀이는 for문을 따로 두번 씀
public class Ex09 {

    public int solution(int n, int[][] arr) {
        int answer = 0 , arrV = 0, arrH = 0, arrD1 = 0, arrD2 = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arrV += arr[i][j];
                arrH += arr[j][i];
            }
            arrD1 += arr[i][i];
            arrD2 += arr[i][n-i-1];
            answer = Math.max(answer, arrV);
            answer = Math.max(answer, arrH);
            arrV = 0;
            arrH = 0;
        }
        answer = Math.max(answer, arrD1);
        answer = Math.max(answer, arrD2);
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex09 T = new Ex09();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); //nextInt()랑 달라
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(T.solution(n, arr));
        br.close();
    }
}
