package Programmers.Lv2;

//2022 KAKAO TECH INTERNSHIP
//두 큐 합 같게 만들기

//TC 11,28 시간초과

import java.util.LinkedList;
import java.util.Queue;

class Ex08_TLE2 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long q1_sum = 0, q2_sum = 0, tmp = 0;
        Queue<Long> q1 = new LinkedList<>();
        for(int i=0; i<queue1.length; i++) {
            tmp = queue1[i];
            q1.offer(tmp);
            q1_sum += tmp;
        }
        Queue<Long> q2 = new LinkedList<>();
        for(int i=0; i<queue2.length; i++) {
            tmp = queue2[i];
            q2.offer(tmp);
            q2_sum += tmp;
        }

        while(q1_sum != q2_sum) {
            if(q1_sum > q2_sum) {
                tmp = q1.poll();
                q2.offer(tmp);
                q1_sum-=tmp;
                q2_sum+=tmp;
            } else {
                tmp = q2.poll();
                q1.offer(tmp);
                q2_sum-=tmp;
                q1_sum+=tmp;
            }
            if(q1.isEmpty() || q2.isEmpty()) {
                return -1;
            }
            answer++;
        }
        return answer;
    }
}