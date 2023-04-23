package Programmers.Lv2;

//2022 KAKAO TECH INTERNSHIP
//두 큐 합 같게 만들기
/*
queue1	queue2	result
[3, 2, 7, 2]	[4, 6, 5, 1]	2
[1, 2, 1, 2]	[1, 10, 1, 2]	7
[1, 1]	[1, 5]	-1
 */

import java.util.*;

class Ex08_a {
    public static void main(String[] args) {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
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

        int cnt = 0;
        while(q1_sum != q2_sum) {
            cnt++;
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
            if(q1.isEmpty() || q2.isEmpty() || cnt == 300000) {
                System.out.println(-1);
                return;
            }
            answer++;
        }
        System.out.println(answer);
    }
}

// Queue 이용 단순 구현 문제
// queue1, queue2 <= 10^9 -> long 사용
/*
 무한루프 해결 위해 while 반복을 queue1, queue2의 최대길이(300,000)로 제한했지만
 정확하겐 queue 의 size() * 3까지로 제한해야함
 <- 예를 들어, [1,1,1,8,10,9], [1,1,1,1,1,1] 인 경우처럼 두 큐에서의 교환이 전부가 아니라, 한 큐가 비워진 뒤 그 큐를 채우고, 그 다음 다시 그리디하게 찾아가는 경우도 존재하기 때문
    [9] [1,1,1,1,1,1,1,1,1,8,10] (cnt = 5)
    [9,1,1,1,1,1,1,1,1,1] [8, 10] (cnt = 5 + 9) => 14번
 */