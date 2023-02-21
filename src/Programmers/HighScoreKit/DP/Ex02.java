package Programmers.HighScoreKit.DP;

//정수 삼각형(Lv3)
/*
triangle	result
[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]	30
 */
//Baeckjoon Ex1932(정수 삼각형)과 똑같은 문제
class Ex02 {
    static Integer[][] dp;
    static int recur(int depth, int idx, int[][] triangle) {
        if(dp[depth][idx]==null) {
            dp[depth][idx]=Math.max(recur(depth+1,idx,triangle),recur(depth+1,idx+1,triangle))+triangle[depth][idx];
        }
        return dp[depth][idx];
    }
    public static void main(String[] args) {
        int[][] triangle={{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        int answer = 0;
        dp=new Integer[triangle.length][triangle.length];
        for(int i=0; i<triangle.length; i++) {
            dp[triangle.length-1][i]=triangle[triangle.length-1][i];
        }
        answer=recur(0,0,triangle);
        System.out.println(answer);;
    }
}