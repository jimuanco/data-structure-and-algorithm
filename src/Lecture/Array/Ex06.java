package Lecture.Array;

import java.util.Scanner;
import java.util.ArrayList;

public class Ex06 {

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        String revStr = "";
        int revNum = 0;
        boolean isPrime = true;
        for(int i=0; i<n; i++) {
            String str = String.valueOf(arr[i]);
            for(int j=str.length()-1; j>=0; j--) {
                revStr += str.charAt(j);
                revNum = Integer.parseInt(revStr);
            }
            if(revNum == 2) {
                answer.add(revNum);
            } else if(revNum == 3) {
                answer.add(revNum);
            } else if(revNum != 1){
                for(int k=2; k<=(int)Math.sqrt(revNum); k++) {
                    if(revNum % k == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime) {
                    answer.add(revNum);
                }
                isPrime = true;
            }
            revStr ="";
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex06 T = new Ex06();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt();
        }
        for(int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
