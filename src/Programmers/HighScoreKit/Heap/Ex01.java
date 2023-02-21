package Programmers.HighScoreKit.Heap;

import java.util.*;

//더 맵게
/*
scoville	K	return
[1, 2, 3, 9, 10, 12]	7	2
 */
class Ex01 {
    public static void main(String[] args) {
        int[] scoville={1,2,3,9,10,12};
        int K = 7;
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++) {
            pQ.offer(scoville[i]);
        }
        while(pQ.size()>1) {
            int tmp1=pQ.poll();
            int tmp2=pQ.poll();
            if(!(tmp1>=K && tmp2>=K)) {
                int tmp3=tmp1+tmp2*2;
                pQ.offer(tmp3);
                answer++;
            } else break;
        }
        if(pQ.size()==1 && pQ.peek()<K) answer=-1;
        System.out.println(answer);
    }
}