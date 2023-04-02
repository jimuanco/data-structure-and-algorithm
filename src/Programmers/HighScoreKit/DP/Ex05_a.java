package Programmers.HighScoreKit.DP;

//도둑질(Lv4)
/*
money	return
[1, 2, 3, 1]	4
 */

/*
분기점은 처음 도둑질 할 때,
-첫 번째 집을 고르냐
-두 번째 집을 고르냐
 */

class Ex05_a {
    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1};
        int[] dp_first = new int[money.length];
        int[] dp_second = new int[money.length];

        for(int i=0; i<money.length; i++) {
            dp_first[i] = money[i];
            dp_second[i] = money[i];
        }

        dp_first[1] = -1;
        dp_second[0] = -1;
        dp_first[2] += dp_first[0];

        for(int i=3; i<money.length; i++) {
            dp_first[i] += Math.max(dp_first[i-2], dp_first[i-3]);
            dp_second[i] += Math.max(dp_second[i-2], dp_second[i-3]);
        }

        int first_max = Math.max(dp_first[money.length-2], dp_first[money.length-3]);
        int second_max = Math.max(dp_second[money.length-1], dp_second[money.length-2]);
        int answer = Math.max(first_max, second_max);
        System.out.println(answer);
    }
}
