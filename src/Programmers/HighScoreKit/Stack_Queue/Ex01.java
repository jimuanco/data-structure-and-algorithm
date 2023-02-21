package Programmers.HighScoreKit.Stack_Queue;

import java.util.*;

//같은 숫자는 싫어
/*
arr	answer
[1,1,3,3,0,1,1]	[1,3,0,1]
[4,4,4,3,3]	[4,3]
 */
public class Ex01 {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        int[] answer = {};
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(arr[0]);
        for(int i=1; i<arr.length; i++) {
            if(arr[i]!=arr[i-1]) arr2.add(arr[i]);
        }
        answer=new int[arr2.size()];
        for(int i=0; i<arr2.size(); i++) {
            answer[i]=arr2.get(i);
        }
//        System.out.println(answer);
        for(int x : answer) {
            System.out.print(x);
        }
    }
}