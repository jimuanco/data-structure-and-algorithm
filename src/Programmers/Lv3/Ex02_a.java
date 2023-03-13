package Programmers.Lv3;

//파괴되지 않은 건물(Lv3)
/*
board	skill	result
[[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]]	[[1,0,0,3,4,4],[1,2,0,2,3,2],[2,1,0,3,1,2],[1,0,1,3,3,1]]	10
[[1,2,3],[4,5,6],[7,8,9]]	[[1,1,1,2,2,4],[1,0,0,1,1,2],[2,2,0,2,0,100]]	6
 */
//IMOS 알고리즘 (누적합) 사용
class Ex02_a {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] preSum = new int[board.length + 1][board[0].length + 1];
        for(int i=0; i<skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];

            if(type == 1) {
                preSum[r1][c1] += -degree;
                preSum[r1][c2+1] += degree;
                preSum[r2+1][c1] += degree;
                preSum[r2+1][c2+1] += -degree;
            } else {
                preSum[r1][c1] += degree;
                preSum[r1][c2+1] += -degree;
                preSum[r2+1][c1] += -degree;
                preSum[r2+1][c2+1] += degree;
            }
        }

        //가로 누적합
        for(int i=0; i<preSum.length; i++) {
            int sum = 0;
            for(int j=0; j<preSum[0].length; j++) {
                sum += preSum[i][j];
                preSum[i][j] = sum;
            }
        }

        //세로 누적합
        for(int i=0; i<preSum[0].length; i++) {
            int sum = 0;
            for(int j=0; j<preSum.length; j++) {
                sum += preSum[j][i];
                preSum[j][i] = sum;
            }
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] + preSum[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}