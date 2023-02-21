package Programmers.HighScoreKit.Sort;

import java.util.*;

//가장 큰 수(Lv2)
/*
numbers	return
[6, 10, 2]	"6210"
[3, 30, 34, 5, 9]	"9534330"
 */
//Baekjoon Ex16496(큰 수 만들기)와 똑같은 문제
class Ex02_a {
    public static void main(String[] args) {
        int[] numbers={6,10,2};
        String answer = "";
        String[] str = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            str[i]=String.valueOf(numbers[i]);
        }
//        Arrays.sort(str, new Comparator<String>() {
//            @Override
//            public int compare(String a, String b) {
//                return (b+a).compareTo(a+b);
//            }
//        });
        Arrays.sort(str, (a, b) -> ((b+a).compareTo(a+b)));
        if(str[0].equals("0")) System.out.println("0"); //"0000" 이라면 0출력
        for(String s : str) {
            answer+=s;
        }
        System.out.println(answer);;
    }
}