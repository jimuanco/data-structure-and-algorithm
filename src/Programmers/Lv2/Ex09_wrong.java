package Programmers.Lv2;

//연습문제
//택배상자(Lv2)

// TC 6~10/10 틀림
/*
 반례
 [3, 5, 4, 2, 1] 5
 */
import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for(int i=0; i<order.length; i++) {
            if(!stack.isEmpty() && stack.peek() == order[i]) {
                stack.pop();
                answer++;
                continue;
            }
            while(idx<order.length && idx+1 != order[i]) {
                stack.push(idx+1);
                idx++;
            }
            if(idx == order.length) {
                break;
            }
            answer++;
        }
        return answer;
    }
}
