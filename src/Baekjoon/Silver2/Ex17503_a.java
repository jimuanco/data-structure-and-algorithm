package Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Beer implements Comparable<Beer>{
    int preference, degree;
    Beer(int preference, int degree) {
        this.preference=preference;
        this.degree=degree;
    }
    @Override
    public int compareTo(Beer ob) {
        return this.degree-ob.degree;
    }
}

//맥주 축제
public class Ex17503_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Beer> arr = new ArrayList<>();
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr.add(new Beer(p,d));
        }
        Collections.sort(arr);
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        int sum=0;
        for(int i=0; i<k; i++) {
            sum+=arr.get(i).preference;
            pQ.offer(arr.get(i).preference);
            if(pQ.size()>n) {
                sum-=pQ.poll();
            }
            if(pQ.size()==n && sum>=m) {
                System.out.println(arr.get(i).degree);
                return;
            }
        }
        System.out.println(-1);
    }
}
