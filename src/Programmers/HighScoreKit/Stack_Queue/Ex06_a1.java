package Programmers.HighScoreKit.Stack_Queue;

//주식가격(Lv2)
/*
prices	return
[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
 */
import java.util.*;

class Ex06_a1 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<prices.length; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        for(int x : answer) {
            System.out.print(x+" ");
        }
    }
}