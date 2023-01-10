package Lecture.Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex03_a {
    public int[] solution(int n, int[] arr) {
        for(int i=0; i<n; i++) {
            int tmp=arr[i], j;
            for(j=i-1; j>=0; j--) {
                if(arr[j]>tmp) arr[j+1]=arr[j];
                else break;
            }
            arr[j+1]=tmp;
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        Ex03_a T = new Ex03_a();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for(int x : T.solution(n, arr)) {
            sb.append(x+" ");
        }
        br.close();
        System.out.print(sb);
    }
}
