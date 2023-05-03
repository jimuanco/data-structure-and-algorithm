package Programmers.Lv2;

//연습문제
//요격 시스템(Lv2)

/*
targets	result
[[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]	3
 */

//Programmers.HighScoreKit.Greedy.Ex06_a(단속 카메라)와 거의 같은 문제
//단속 카메라 문제와 마찬가지로 마지막 지점(e)을 기준으로 따진다.
//다만 이 문제는 e의 좌표에서는 요격이 안되기때문에 -1을 해주었다.

import java.util.*;

class Ex18 {
    public static void main(String[] args) {
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> (o1[1] - o2[1]));
        int interceptor = Integer.MIN_VALUE;
        for(int[] target : targets) {
            if(interceptor < target[0]) {
                interceptor = target[1]-1;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
