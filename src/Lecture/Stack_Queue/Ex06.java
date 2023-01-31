package Lecture.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//공주 구하기
//복습 할 때 다시 풀어 봄
public class Ex06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        Queue<Integer> Q = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            Q.offer(i);
        }
        int cnt=0, answer=0;
        while(!Q.isEmpty()) {
            int tmp = Q.poll();
//            if(Q.size()==1) { //여기에 있으면 틀림
//                answer=Q.peek();
//                break;
//            }
            cnt++;
            if(cnt%k!=0) Q.offer(tmp);
            if(Q.size()==1) {
                answer=Q.peek();
                break;
            }
        }
        System.out.println(answer);
    }
}
