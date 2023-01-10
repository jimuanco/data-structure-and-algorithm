package Lecture.Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//선택정렬
public class Ex01_a {
    public int[] solution(int n, int[] arr) {
        for(int i=0; i<n-1; i++) {
            int idx=i;
            for(int j=i+1; j<n; j++) {
                if(arr[j]<arr[idx]) idx=j;
            }
            int tmp = arr[i];
            arr[i]=arr[idx];
            arr[idx]=tmp;
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        Ex01_a T = new Ex01_a();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for( int x : T.solution(n, arr)) {
            sb.append(x + " ");
        }
        System.out.print(sb);
    }
}
