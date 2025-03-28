package Review.Programmers.HighScoreKit.BinarySearch;

import java.util.*;

//징검다리(Lv4)
/*
distance	rocks	n	return
25	[2, 14, 11, 21, 17]	2	4
 */
public class Ex02_timeLimitExceeded {
    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        Solution s = new Solution();
        int answer = s.solution(distance, rocks, n);
        System.out.println(answer);
    }
}

class Solution {
    int[] combi;
    int size, m, answer;
    public int solution(int distance, int[] rocks, int n) {
        size = rocks.length;
        m = rocks.length - n;
        combi = new int[m];
        Arrays.sort(rocks);
        DFS(0, 0, rocks, distance);
        return answer;
    }
    private void DFS(int L, int s, int[] rocks, int distance) {
        if (L == m) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                if (i == 0) {
                    min = Math.min(min, combi[i]);
                } else if (i == m - 1) {
                    min = Math.min(min, distance - combi[i]);
                } else {
                    min = Math.min(min, combi[i] - combi[i - 1]);
                }
            }
            answer = Math.max(answer, min);
        } else {
            for (int i = s; i < size; i++) {
                combi[L] = rocks[i];
                DFS(L + 1, i + 1, rocks, distance);
            }
        }
    }
}
