package Baekjoon.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Jewel implements Comparable<Jewel> {
    public int weight, price;
    Jewel(int weight, int price) {
        this.weight=weight;
        this.price=price;
    }
    public int compareTo(Jewel ob) {
        return this.weight-ob.weight;
    }
}

//보석 도둑

//자료형 주의!!
//1초 시간 제한이지만 for문 이 문제에서 처럼 쓰면 됨
//Lecture Greedy Ex04(최대수입스케줄)과 비슷한 유형!
public class Ex1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        ArrayList<Jewel> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int w=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            arr.add(new Jewel(w,p));
        }
        int[] bag=new int[k];
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            bag[i]=Integer.parseInt(st.nextToken());
        }
        Collections.sort(arr);
        Arrays.sort(bag);
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        long answer=0; //자료형 주의!!
        int j=0;
        // N과 K가 주어진다. (1 ≤ N, K ≤ 300,000)
        // for문 이런식으로 쓰면 1초 제한이지만 가능함 (1572ms 나옴)
        for(int i=0; i<k; i++) {
            for( ; j<n; j++) {
                if(arr.get(j).weight>bag[i]) break;
                pQ.offer(arr.get(j).price);
            }
            if(!pQ.isEmpty()) answer+=pQ.poll();
        }
        System.out.println(answer);
    }
}
