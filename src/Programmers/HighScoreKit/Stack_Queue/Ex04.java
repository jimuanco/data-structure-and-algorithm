package Programmers.HighScoreKit.Stack_Queue;


//프린터(Lv2)
/*
priorities	location	return
[2, 1, 3, 2]	2	1
[1, 1, 9, 1, 1, 1]	0	5
 */
//Lecture.Stack_Queue.Ex08(응급실)과 똑같은 문제
import java.util.*;

class Paper {
    int index, priority;
    Paper(int index, int priority) {
        this.index=index;
        this.priority=priority;
    }
}

class Ex04 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Paper> Q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            Q.offer(new Paper(i, priorities[i]));
        }
        while(!Q.isEmpty()) {
            Paper tmp = Q.poll();
            for(Paper x : Q) {
                if(x.priority>tmp.priority) {
                    Q.offer(tmp);
                    tmp=null;
                    break;
                }
            }
            if(tmp!=null) {
                answer++;
                if(tmp.index==location) {
                    return answer;
                }
            }
        }
        return answer;
    }
}