package Baekjoon.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//카드 정렬하기
//자료형 long 안써도 되네
public class Ex1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQ= new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            pQ.offer(Integer.parseInt(br.readLine()));
        }
        int answer=0;
        if(pQ.size()==1) {
            System.out.println(0); //여기 주의! 카드 묶음이 하나일땐 0번 비교임
            System.exit(0);
        }
        while(!pQ.isEmpty()) {
            int sum=pQ.poll()+pQ.poll();
            pQ.offer(sum);
            answer+=sum;
            if(pQ.size()==1) break;
        }
        System.out.println(answer);
    }
}
