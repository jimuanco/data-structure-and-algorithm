package Programmers.Lv3;

import java.util.*;

//야근 지수
/*
works	n	result
[4, 3, 3]	4	12
[2, 1, 2]	1	6
[1,1]	3	0
 */
class Ex01 {
    public static void main(String[] args) {
        int n = 4;
        int[] works = {4, 3, 3};
        long answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++) {
            pQ.offer(works[i]);
        }
        while(n>0 && !pQ.isEmpty()) {
            int tmp=pQ.poll();
            if(n==0) break;
            if(tmp-1!=0) {
                pQ.offer(tmp-1);
            }
            n--;
        }
        for(int x : pQ) {
            answer+=Math.pow(x,2);
        }
        System.out.println(answer);
    }
}