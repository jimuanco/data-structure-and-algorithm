package Lecture.Array;

import java.util.Scanner;

//소수(에라토스테네스 체)
public class Ex05_a {

    public int solution(int n) {
        int cnt = 0;
        int[] ch = new int[n+1];
        for(int i=2; i<=n; i++) {
            if(ch[i]==0) {
                cnt++;
                for(int j=i; j<=n; j=j+i) ch[j] = 1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Ex05_a T = new Ex05_a();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}
