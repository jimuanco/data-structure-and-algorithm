package Programmers.HighScoreKit.DP;

//등굣길(Lv3)
/*
m	n	puddles	return
4	3	[[2, 2]]	4
 */

//탐색시 무조건 최단 경로이다.
//집이 무조건 오른쪽 아래에 존재하고, 2.오른쪽 또는 아래로 밖에 탐색을 못한다.
//즉, 중간에 길이 가로막혀 삥 둘러가는 경우는 존재하지 않는다.
//따라서 단순하게 DP 배열만으로 풀 수 있음
class Ex03_a {
    public static void main(String[] args) {
        int m=4;
        int n=3;
        int[][] puddles={{2,2}};
        int answer = 0;
        int[][] dp = new int[n][m];
        for(int i=0; i<puddles.length; i++) {
            dp[puddles[i][1]-1][puddles[i][0]-1]=-1; //행,열이 반대임...조심!
        }
        dp[0][0]=1;
        int mod=1000000007;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(dp[i][j]==-1) continue;
                if(i+1<n && dp[i+1][j]!=-1) {
                    dp[i+1][j]+=dp[i][j]%mod; //매번 나눠 줘야함
                }
                if(j+1<m && dp[i][j+1]!=-1) {
                    dp[i][j+1]+=dp[i][j]%mod; //매번 나눠 줘야함
                }
            }
        }
        answer=dp[n-1][m-1]%mod;
        System.out.println(answer);;
    }
}