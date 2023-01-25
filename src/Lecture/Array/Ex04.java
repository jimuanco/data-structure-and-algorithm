package Lecture.Array;

import java.util.ArrayList;
import java.util.Scanner;

//피보나치 수열
public class Ex04 {

    public ArrayList<String> solution(int n) {
        ArrayList<String> answer = new ArrayList<>();
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        answer.add("1");
        for(int i=2; i<=n; i++) {
            arr[i] = arr[i-2] + arr[i-1];
            answer.add(String.valueOf(arr[i]));
        }
        return answer;
    }

    public static void main(String[] args) {
        Ex04 T = new Ex04();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        for(String s : T.solution(n)) {
            System.out.print(s + " ");
        }
    }
}
