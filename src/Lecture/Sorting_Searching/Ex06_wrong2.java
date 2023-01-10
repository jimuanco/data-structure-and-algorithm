package Lecture.Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//같은 키의 학생들 고려해야함
public class Ex06_wrong2 {
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer1 = new ArrayList<>();
        ArrayList<Integer> answer2 = new ArrayList<>();
        for(int i=0; i<n-1; i++) {
            if(arr[i]>arr[i+1]) {
                if(answer1.isEmpty()) answer1.add(i+1);
                else {
                    answer1.add(i+2);
                    return answer1;
                }
            }
            if(arr[i]==arr[i+1]) {
                answer2.add(i+1);
                answer2.add(i+2);
            }
        }
        return answer2;
    }

    public static void main(String[] args) throws IOException {
        Ex06_wrong2 T = new Ex06_wrong2();
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
