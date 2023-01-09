package Lecture.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex11_wrong {

    public int solution(int n, int[][] arr) {
        int answer = 0, max = Integer.MIN_VALUE;
        int [] student = new int[n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    if((j+k+1) < n && arr[j][i] == arr[j+k+1][i]) {
                        student[j]++;
                        student[j+k+1]++;
                    }
                }
            }
        }
        for(int i=0; i<n; i++) {
            if(max < student[i]) {
                max = student[i];
                answer=i+1;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        Ex11_wrong T = new Ex11_wrong();
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
