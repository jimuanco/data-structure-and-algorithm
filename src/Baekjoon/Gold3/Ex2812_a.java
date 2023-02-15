package Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//크게 만들기

//Stack이용
//현재 스택에 들어있는 값이 들어올 수 보다 크거나 같으면 그냥 push하고 작으면 pop을 하는 방식
public class Ex2812_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        String input = br.readLine();
        char[] ch = input.toCharArray();
        for(int i=0; i<n; i++) {
            arr[i]=ch[i]-'0'; //주의 !! +'0'하면 안돼
        }
        Stack<Integer> stack = new Stack<>();
        int cnt=k;
        for(int i=0; i<n; i++) {
//            if(n-i==cnt) break; (밑에 밑에 while문 대신 이거 쓰면 반례생김)
            if(stack.isEmpty()) stack.push(arr[i]); //비어 있을땐 push
            else {
                if(stack.peek()<arr[i]) { //들어올 값보다 작으면 k개 지울때까지 또는 stack이 비어있을때까지 또는 들어올 값보다 크거나 같을때까지 pop() 후 push()
                    while(cnt!=0 && !stack.isEmpty() && stack.peek() < arr[i]) {
                        stack.pop();
                        cnt--;
                        if(cnt==0) break;
                    }
                    stack.push(arr[i]);
                } else { //들어올 값보다 크거나 같으면 push()
                    stack.push(arr[i]);
                }
            }
        }
        //이 while문 지우고 위에 주석(if(n-i==cnt) break;)을 써버리면 반례생김
        //4 2
        //1924
        while(stack.size()>n-k) { //숫자에 내림차순이 포함돼 있을 경우 k개를 다 지우지 못했을 수  있다. 그땐 제일 오른쪽숫자부터 제거해준다.
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        for(int x : stack) {
            sb.append(x);
        }
        System.out.println(sb);
    }
}
