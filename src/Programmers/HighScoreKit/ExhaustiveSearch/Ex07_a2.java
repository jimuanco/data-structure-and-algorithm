package Programmers.HighScoreKit.ExhaustiveSearch;

//모음사전
/*
word	result
"AAAAE"	6
"AAAE"	10
"I"	1563
"EIO"	1189
 */

//완전탐색으로 풀기
import java.util.*;

class Ex07_a2 {
    static char[] arr = {'A', 'E', 'I', 'O', 'U'};
    static List<String> list = new ArrayList<>();
    static void DFS(int L, String str) {
        list.add(str);

        if(L == 5) {
            return;
        } else {
            for(int i=0; i<arr.length; i++) {
                DFS(L+1, str+arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        String word = "EIO";
        int answer = 0;
        DFS(0,"");
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals(word)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(answer);
    }
}