package Programmers.HighScoreKit.Stack_Queue;

//다리를 지나는 트럭(lv2)
/*
bridge_length	weight	truck_weights	return
2	10	[7,4,5,6]	8
100	100	[10]	101
100	100	[10,10,10,10,10,10,10,10,10,10]	110
 */
import java.util.*;

class Ex05_a {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();
        int sum=0; // 다리를 건너는 트럭들의 무게 합
        for(int t : truck_weights) {
            while(true) {
                //큐가 비어있다면 다음 트럭 삽입
                if(Q.isEmpty()) {
                    Q.offer(t);
                    sum += t;
                    answer++;
                    break;
                } else if(Q.size() == bridge_length) { //큐의 사이즈와 다리의 길이가 같다면 큐에서 처음 값을 빼고 sum 에서 뺌
                    sum -= Q.poll();
                } else { //큐가 비어있지 않을 때
                    //다음 트럭이 최대 무게 초과
                    if(sum + t > weight) {
                        Q.offer(0);
                        answer++;
                    } else { //다음 트럭이 최대 무게 이내
                        Q.offer(t);
                        sum += t;
                        answer++;
                        break;
                    }
                }
            }
        }
        //걸린 시간 + 마지막 트럭의 통과시간(다리의 길이)
        return answer + bridge_length;
    }
}