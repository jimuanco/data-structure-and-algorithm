package Lecture.Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//중복 확인
public class Ex05 {
    public Character solution(int n, int[] arr) {
        char answer='U';
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                if(arr[i]==arr[j]) return 'D';
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex05 T = new Ex05();
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
