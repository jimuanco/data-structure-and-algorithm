package Programmers.HighScoreKit.DP;

import java.util.*;

//N으로 표현(Lv3)
/*
N	number	return
5	12	4
2	11	3
 */
class Ex01_a {
    public static void main(String[] args) {
        int N=5;
        int number=12;
        int answer = -1;
        Set<Integer>[] set = new HashSet[9];
        int n=0;
        for(int i=1; i<9; i++) { //1~8번까지 N의 연속수를 미리 넣어줌
            n=(n*10)+N;
            set[i]=new HashSet<>();
            set[i].add(n);
        }
        //DP->메모이제이션(이전 값들을 이용해서 모든 경우를 따짐)
        for(int i=2; i<9; i++) {
            for(int j=1; j<i; j++) { //i번째 set을 만들기 위한 i밑 번호 조합을 전부 따짐
                for(int a : set[j]) { //j번째와
                    for(int b : set[i-j]) { //i-j번째 사칙연산의 조합을 저장
                        set[i].add(a+b);
                        set[i].add(a-b);
                        set[i].add(a*b);
                        //나눗셈은 순서를 따져야 하므로
                        if(b!=0) {
                            set[i].add(a/b);
                        }
                        if(a!=0) {
                            set[i].add(b/a);
                        }
                    }
                }
            }
        }
        for(int i=1; i<9; i++) {
            if(set[i].contains(number)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(answer);
    }
}