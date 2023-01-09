package Lecture.Array;

import java.util.Scanner;

public class Ex05 {

    public void solution(int n) {
        int n2 = n-1;
        for(int i=2; i<=n; i++) {
            for(int j=2; j<=(int)Math.sqrt(i); j++) {
                if(i % j == 0) {
                    n2--;
                    break;
                }
            }
        }
        System.out.println(n2);
    }

    public static void main(String[] args) {
        Ex05 T = new Ex05();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        T.solution(n);

    }
}

//에라토스테네스 체 써