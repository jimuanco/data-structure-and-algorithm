package Programmers.Lv2;

//연습문제
//택배상자(Lv2)

/*
order	result
[4, 3, 1, 2, 5]	2
[5, 4, 3, 2, 1]	5
 */
import java.util.*;

class Ex09_a {
    public static void main(String[] args) {
        int[] order = {4, 3, 1, 2, 5};
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int idx = 0, num = 1;
        while(true) {
            if(!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
                answer++;
                continue;
            }

            if(num > order.length) {
                break;
            }

            if(order[idx] == num) {
                idx++;
                num++;
                answer++;
                continue;
            }

            stack.push(num++);
        }
        System.out.println(answer);
    }
}