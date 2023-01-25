package Lecture.Array;

import java.util.Scanner;

//보이는 학생
public class Ex02 {
    public int solution(int n, int[] arr) {
        int answer = 1;
        int tmp = arr[0];
        for(int i=0; i<n-1; i++) {
            if(tmp < arr[i+1]) {
                answer++;
                tmp = arr[i+1];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Ex02 T = new Ex02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
