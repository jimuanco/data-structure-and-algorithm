package Programmers.Lv2;

//연습문제
//숫자 변환하기

/*
x	y	n	result
10	40	5	2
10	40	30	1
2	5	4	-1
 */

//dp로 풀기

class Ex20_a2 {
    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 5;

        int[] dp = new int[y+1];
        for(int i=x; i<=y; i++) {
            if(i!=x && dp[i]==0) {
                dp[i] = -1;
                continue;
            }
            if(i*2<=y) {
                dp[i*2] = (dp[i*2]==0) ? dp[i]+1 : Math.min(dp[i]+1, dp[i*2]);
            }
            if(i*3<=y) {
                dp[i*3] = (dp[i*3]==0) ? dp[i]+1 : Math.min(dp[i]+1, dp[i*3]);
            }
            if(i+n<=y) {
                dp[i+n] = (dp[i+n]==0) ? dp[i]+1 : Math.min(dp[i]+1, dp[i+n]);
            }
        }
        System.out.println(dp[y]);
    }
}
