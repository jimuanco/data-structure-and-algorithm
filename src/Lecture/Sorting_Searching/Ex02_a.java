package Lecture.Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//버블정렬
public class Ex02_a {
    public int[] solution(int n, int[] arr) {
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {
                 if(arr[j]>arr[j+1]) {
                     int tmp=arr[j];
                     arr[j]=arr[j+1];
                     arr[j+1]=tmp;
                 }
            }
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        Ex02_a T = new Ex02_a();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for(int x : T.solution(n, arr)) {
            sb.append(x+" ");
        }
        System.out.print(sb);
    }
}
