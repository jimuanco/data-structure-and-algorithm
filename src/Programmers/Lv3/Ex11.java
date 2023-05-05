package Programmers.Lv3;

//2020 카카오 인턴십
//경주로 건설(Lv3)

/*
board	result
[[0,0,0],[0,0,0],[0,0,0]]	900
[[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0],[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,0]
,[0,0,0,1,0,0,0,1],[0,0,1,0,0,0,1,0],[0,1,0,0,0,1,0,0],[1,0,0,0,0,0,0,0]]	3800
[[0,0,1,0],[0,0,0,0],[0,1,0,1],[1,0,0,0]]	2100
[[0,0,0,0,0,0],[0,1,1,1,1,0],[0,0,1,0,0,0],[1,0,0,1,0,1],[0,1,0,0,0,1],[0,0,0,0,0,0]]	3200
 */

class Ex11 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer = Integer.MAX_VALUE;
    static int[][] dp;

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
        dp = new int[board.length][board[0].length];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        board[0][0]=1;
        DFS(0,0,'s',board,0);
        System.out.println(answer);
    }

    static void DFS(int x, int y, char dir, int[][] board, int sum) {

        // TC 3번의 경우를 보면 dp[x][y]<=sum 로 두면 안되는 이유를 알 수 있다.
        // 같은 위치에 같은 sum 으로 도달 한 두 경로가 그 다음 위치에서 +600 or +100으로 나뉠 수 있다.
        // 이렇게 해도 정답이지만 정확하게 할려면
        // dp 초기화를 Integer.MAX_VALUE - 1000 정도로 하고 dp[x][y]+500<sum 으로 해야 할 듯. (조금 애매하네)
        if(dp[x][y]<sum) {
            return;
        } else {
            dp[x][y]=sum;
        }
        if(sum>=answer) return;
        if(x==board.length-1 && y==board[0].length-1) {
            answer = sum;
        } else {
            for(int i=0; i<4; i++) {
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length && board[nx][ny]==0) {
                    board[nx][ny]=1;
                    if(dx[i]==0 && dir == 'v') {
                        DFS(nx,ny,'h',board,sum+600);
                    } else if(dy[i]==0 && dir =='h') {
                        DFS(nx,ny,'v',board,sum+600);
                    } else if(dx[i]==0) {
                        DFS(nx,ny,'h',board,sum+100);
                    } else {
                        DFS(nx,ny,'v',board,sum+100);
                    }
                    board[nx][ny]=0;
                }
            }
        }
    }
}
