package Programmers.HighScoreKit.Greedy;

import java.util.*;

//큰 수 만들기(Lv2)
/*
number	k	return
"1924"	2	"94"
"1231234"	3	"3234"
"4177252841"	4	"775841"
 */

//Baekjoon Ex2812(크게 만들기)와 똑같은 문제
class Ex03 {
    public static void main(String[] args) {
        String number="1924";
        int k=2;
        String answer = "";
        int[] arr=new int[number.length()];
        for(int i=0; i<number.length(); i++) {
            arr[i]=number.charAt(i)-48;
        }
        Stack<Integer> stack = new Stack<>();
        int cnt=k;
        for(int i=0; i<number.length(); i++) {
            if(stack.isEmpty()) stack.push(arr[i]);
            else {
                if(stack.peek()<arr[i]) {
                    while(cnt!=0 && !stack.isEmpty() && stack.peek()<arr[i]) {
                        stack.pop();
                        cnt--;
                        if(cnt==0) {
                            break;
                        }
                    }
                    stack.push(arr[i]);
                } else {
                    stack.push(arr[i]);
                }
            }
        }
        while(stack.size()>number.length()-k) {
            stack.pop();
        }
        for(int x : stack) {
            answer+=x;
        }
        System.out.println(answer);;
    }
}