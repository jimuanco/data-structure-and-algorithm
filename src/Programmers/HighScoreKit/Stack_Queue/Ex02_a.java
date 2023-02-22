package Programmers.HighScoreKit.Stack_Queue;

import java.util.*;

//기능 개발(Lv2)
/*
progresses	speeds	return
[93, 30, 55]	[1, 30, 5]	[2, 1]
[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
 */
class Ex02_a {
    public static void main(String[] args) {
        int[] progresses={93,30,55};
        int[] speeds={1,30,5};
        Queue<Integer> Q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            Q.offer((int)Math.ceil((100.0-progresses[i])/speeds[i])); //주의!! 100.0 (소수점 꼭 넣어줘야 해, 아니면 마지막 테스트케이스 실패 뜸)
        }
        List<Integer> answer= new ArrayList<>();
        while(!Q.isEmpty()) {
            int cnt=1;
            int day=Q.poll();
            while(!Q.isEmpty() && day>=Q.peek()) {
                cnt++;
                Q.poll();
            }
            answer.add(cnt);
        }
        answer.stream().mapToInt(Integer::intValue).toArray();
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }
}