package Lecture.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//크레인 인형뽑기(카카오)
public class Ex03_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] board=new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int m=Integer.parseInt(br.readLine());
        int[] moves=new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            moves[i]=Integer.parseInt(st.nextToken());
        }
        int answer=0;
        Stack<Integer> stack = new Stack<>();
        for(int pos : moves) {
            for(int i=0; i<board.length; i++) { //row길이 cf) column길이->board[0].length
                if(board[i][pos-1]!=0) {
                    int tmp=board[i][pos-1];
                    board[i][pos-1]=0;
                    if(!stack.isEmpty() && tmp==stack.peek()) {
                        answer+=2;
                        stack.pop();
                    } else stack.push(tmp);
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
