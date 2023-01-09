package Lecture.Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex03 {

    public ArrayList<String> solution(int n, int[] arr1, int[] arr2) {
        ArrayList<String> answer = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if((arr1[i]-arr2[i]) < 0) {
                if((arr1[i]-arr2[i]) == -2)
                answer.add("A");
                else answer.add("B");

            } else if((arr1[i]-arr2[i]) == 0) {
                answer.add("D");
            } else {
                if((arr1[i]-arr2[i]) == 2)
                    answer.add("B");
                else answer.add("A");
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Ex03 T = new Ex03();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i=0; i<n; i++) {
            arr1[i] = kb.nextInt();
        }
        for(int i=0; i<n; i++) {
            arr2[i] = kb.nextInt();
        }
        for(String s : T.solution(n, arr1, arr2)) {
            System.out.println(s);
        }
    }
}
