package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//주유소
//자료형 주의!!
//58점 나옴 (나머지 42점은 n값의 범위가 더 크므로 n으로 만들어야 하는데 그렇지 못해 시간초과로 감점)
//우선순위 큐에서의 시간 복잡도는 삽입, 삭제 시 O(logN)의 시간이 걸린다.
//따라서 for문안에 PriorityQueue의 remove를 매번 해주므로 NlogN의 시간이 걸리는듯?
public class Ex13305_wrong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long[] price=new long[n-1];
        long[] dis=new long[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++) {
            dis[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pQ = new PriorityQueue<>();
        for(int i=0; i<n-1; i++) {
            price[i]=Integer.parseInt(st.nextToken());
            pQ.offer(price[i]);
        }
        long answer=0;
        for(int i=n-2; i>=0; i--) {
            long tmp=pQ.peek();
            answer+=tmp*dis[i];
            pQ.remove(price[i]);
        }
        System.out.println(answer);
    }
}
