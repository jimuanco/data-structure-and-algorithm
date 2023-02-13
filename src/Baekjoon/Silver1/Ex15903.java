package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//카드 합체 놀이
//자료형 주의!!
public class Ex15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pQ = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            pQ.offer(Long.parseLong(st.nextToken()));
        }
        for(int i=0; i<m; i++) {
            long c1=pQ.poll();
            long c2=pQ.poll();
            pQ.offer(c1+c2);
            pQ.offer(c1+c2);
        }
        long answer=0;
        for(Long x: pQ) {
            answer+=x;
        }
        System.out.println(answer);
    }
}
