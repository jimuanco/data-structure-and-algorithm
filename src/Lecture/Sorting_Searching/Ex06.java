package Lecture.Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//장난꾸러기
public class Ex06 {
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int x : arr) {
            tmp.add(x);
        }
        Arrays.sort(arr);
        for(int i=0; i<n; i++) {
            if(arr[i]!=tmp.get(i)) {
                answer.add(i+1);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex06 T = new Ex06();
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
