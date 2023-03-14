package Programmers.Lv2;

//하노이의 탑(Lv2)
/*
n	result
2	[ [1,2], [1,3], [2,3] ]
 */
/*
전체 과정을 세 과정의 연속으로 분해가능!

hanoi(2, ‘A’, ‘B’, ‘C’) : start에서 3번까지
3번 원반을 ‘C’로 옮기기 위해서는 먼저 위의 두 원반을 ‘B’로 옮겨야 한다.
이후 3번 원반을 ‘C’로 옮긴다 : 4번
hanoi(2, ‘B’, ‘C’, ‘A’) : 5번 ~
3번을 ‘C’로 옮긴 후 ‘B’에 있는 두 개의 원반을 ‘C’로 옮긴다. 이때 ‘A’를 경유한다.
원반의 개수(n)가 몇 개가 되든 결국 이 과정을 거친다. 한 번의 재귀, 가장 큰 원반 옮기기 이후 다시 한 번의 재귀. 물론 이때 예외가 있다.
n이 1일 때는 자신의 위에 원반이 없기 때문에 재귀가 필요없고 바로 원반을 옮기고 종료한다. 이것이 곧 재귀함수의 탈출 조건, 또는 기저 사례(base case)가 된다.
 */
import java.util.*;

class Ex01_a {
    ArrayList<int[]> seq;
    void hanoi(int n, int from, int to, int via) {
        int[] move = {from, to};

        if(n==1) {
            seq.add(move);
        } else {
            hanoi(n-1, from, via, to);
            seq.add(move);
            hanoi(n-1, via, to, from);
        }
    }

    public int[][] solution(int n) {
        seq = new ArrayList<>();

        hanoi(n, 1, 3, 2);

        int[][] answer = new int[seq.size()][2];
        for(int i=0; i<seq.size(); i++) {
            int[] cmd = seq.get(i);
            answer[i][0] = cmd[0];
            answer[i][1] = cmd[1];
        }

        return answer;
    }
}