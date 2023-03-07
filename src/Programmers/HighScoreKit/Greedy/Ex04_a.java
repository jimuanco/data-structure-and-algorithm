package Programmers.HighScoreKit.Greedy;

//구명보트(Lv2)
/*
people	limit	return
[70, 50, 80, 50]	100	3
[70, 80, 50]	100	3
 */
//최소한의 횟수로 옮기기 위해서는 가장 몸무게가 큰 사람 + 가장 몸무게가 작은 사람 조합
import java.util.*;

class Ex04_a {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int idx=0;
        for(int i=people.length-1; i>=idx; i--) {
            if(people[idx]+people[i]<=limit) {
                idx++;
            }
            answer++;
        }
        return answer;
    }
}