package Review.Programmers.HighScoreKit.ExhaustiveSearch;

import java.util.Arrays;

//카펫(Lv2)
/*
brown	yellow	return
10	2	[4, 3]
8	1	[3, 3]
24	24	[8, 6]
 */
public class Ex04 {
    public static void main(String[] args) {
        int brown=10;
        int yellow=2;
        int[] answer = {};
        answer = new int[2];
        int num = (brown - 4) / 2;
        for (int i = num - 1; i > 0; i--) {
            if (i * (num - i) == yellow) {
                int max = Math.max(i, num - i);
                int min = Math.min(i, num - i);
                answer[0] = max + 2;
                answer[1] = min + 2;
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
