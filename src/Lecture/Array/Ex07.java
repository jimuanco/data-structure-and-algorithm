package Lecture.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//점수계산
public class Ex07 {

    public int solution(int n, int[] arr) {
        int answer = 0;
        int sc = 0;
        if(arr[0] == 1) {
            sc++;
            answer = sc;
        }
        for(int i=1; i<n; i++) {
            if(arr[i] == 1 && arr[i-1] == 1) {
                sc++;
            } else if(arr[i] == 1 && arr[i-1] == 0) {
                sc = 1;
            } else {
                sc = 0;
            }
            answer += sc;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        Ex07 T = new Ex07();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(n, arr));
    }
}
