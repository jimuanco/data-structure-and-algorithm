package Review.Lecture2025.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 크레인 인형뽑기(카카오)
/*
5
0 0 0 0 0
0 0 1 0 3
0 2 5 0 1
4 2 4 4 2
3 5 1 3 1
8
1 5 3 5 1 2 1 4
 */
// 답은 while이 아닌 for문
public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int m = Integer.parseInt(br.readLine());
        int[] moves = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            while (board[cnt][moves[i] - 1] == 0) {
                cnt++;
                if (cnt == n - 1) {
                    break;
                }
            }
            if (!stack.isEmpty() && stack.peek() == board[cnt][moves[i] - 1]) {
                stack.pop();
                ans++;
            } else {
                stack.push(board[cnt][moves[i] - 1]);
            }
            board[cnt][moves[i] - 1] = 0;
        }
        System.out.println(ans * 2);
    }
}
