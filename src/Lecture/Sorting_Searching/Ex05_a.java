package Lecture.Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//중복 확인
//HashMap으로 풀면 n, 정렬로 풀면 nlogn(HashMap보다 성능이 떨어짐)
public class Ex05_a {
    public String solution(int n, int[] arr) {
        String answer="U";
        Arrays.sort(arr);
        for(int i=0; i<n-1; i++) {
            if(arr[i]==arr[i+1]) return "D";
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex05_a T = new Ex05_a();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        System.out.print(T.solution(n, arr));
    }
}
