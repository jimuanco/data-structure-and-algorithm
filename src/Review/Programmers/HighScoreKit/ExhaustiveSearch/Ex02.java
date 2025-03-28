package Review.Programmers.HighScoreKit.ExhaustiveSearch;

import java.util.*;

//모의고사
/*
answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
 */
public class Ex02 {
    public static void main(String[] args) {
        int[] answers={1,2,3,4,5};
        Solution s = new Solution();
        int[] answer = s.solution(answers);
        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        List<Integer> arr = new ArrayList<>();
        int[] score = new int[3];
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % a.length]) {
                score[0]++;
            }
            if (answers[i] == b[i % b.length]) {
                score[1]++;
            }
            if (answers[i] == c[i % c.length]) {
                score[2]++;
            }
        }
        int max = Arrays.stream(score).max().orElse(Integer.MIN_VALUE);
        for (int i = 0; i < 3; i++) {
            if (score[i] == max) {
                arr.add(i + 1);
            }
        }

        answer = arr.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}

