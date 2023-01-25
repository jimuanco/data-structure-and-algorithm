package Lecture.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//보이는 학생
public class Ex02_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int answer=1, max=arr[0];
        for(int i=1; i<n; i++) {
            if(arr[i]>max) {
                max=arr[i];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
