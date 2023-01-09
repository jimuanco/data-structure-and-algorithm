package Lecture.Array;

import java.util.Scanner;

public class Ex05_2 {

    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n+1];
        for(int i=2; i<n+1; i++) {
            for(int j=i*2; j<n+1; j=j+i) {
                arr[j] = 1;
            }
            if(arr[i] == 0) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Ex05_2 T = new Ex05_2();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}
