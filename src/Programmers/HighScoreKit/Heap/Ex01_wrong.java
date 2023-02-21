package Programmers.HighScoreKit.Heap;

import java.util.*;

//더 맵게
class Ex01_wrong {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Arrays.sort(scoville);
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++) {
            if(scoville[i]>=K) break;
            pQ.offer(scoville[i]);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<scoville.length; i++) {
            if(scoville[i]>=K) arr.add(scoville[i]);
        }
        while(!pQ.isEmpty()) {
            int tmp1=pQ.poll();
            int tmp2;
            if(pQ.isEmpty()) {
                if(arr.size()==0) {
                    answer=-1;
                    break;
                }
                tmp2=arr.get(0);
                arr.remove(0);
            } else {
                tmp2=pQ.poll();
            }
            int tmp3=tmp1+tmp2*2;
            if(tmp3<K) pQ.offer(tmp3); //pQ에 한개만 남았을때 arr에서 꺼내서 섞게 되는데 K보다 작다고 여기서 안넣어버리면 안됨
            answer++;
        }
        return answer;
    }
}
