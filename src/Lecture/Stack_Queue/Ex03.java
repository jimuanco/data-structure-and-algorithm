package Lecture.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//크레인 인형뽑기(카카오)
public class Ex03 {
    public int solution(int n, int[][] arr1, int m, int[] arr2) {
        int answer=0, p=0, prev=0;
        Stack<Integer> stack = new Stack<>();
        for(int x : arr2) {
            while(arr1[p][x-1]==0 && p<n-1) {
                p++;
            }
            if(arr1[p][x-1]==0) { //인형이 없을 경우 0을 stack.push 하면 안됨 (이거 빼도 정답은 뜸..)
                p=0;
                continue;
            }
            stack.push(arr1[p][x-1]);
            if(prev==stack.lastElement()) {
                stack.pop();
                stack.pop();
                answer++;
                prev=stack.lastElement();
            } else {
                prev=arr1[p][x-1];
            }
            arr1[p][x-1]=0;
            p=0;
        }
        return answer*2;
    }

    public static void main(String[] args) throws IOException {
        Ex03 T = new Ex03();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr1 = new int[n][n];

        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        System.out.print(T.solution(n, arr1, m, arr2));
    }
}
