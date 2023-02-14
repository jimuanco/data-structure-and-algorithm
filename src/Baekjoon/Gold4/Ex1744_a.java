package Baekjoon.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//수 묶기
//고생한 문제..
//양수 & 음수,0 -> 나눠서 따지기
//양수는 큰수부터 두 수 씩 곱하고 다만 두 수 중 하나라도 1이라면 더해야함
//음수,0은 작은수 부터 두 수 씩 곱하면 됨
//ArrayList 에서 remove하면 한 칸씩 땡겨와 짐
public class Ex1744_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<Integer> pn=new ArrayList<>();
        ArrayList<Integer> nn=new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int num=Integer.parseInt(st.nextToken());
            if(num>0) {
                pn.add(num);
            } else nn.add(num);
        }
        Collections.sort(pn,Collections.reverseOrder());
        Collections.sort(nn);
        int answer=0;
        while(!pn.isEmpty()) {
            if(pn.size()>1) {
                if(pn.get(0)==1 || pn.get(1)==1) {
                    answer+=pn.get(0)+pn.get(1);
                }else answer+=pn.get(0)*pn.get(1);
                pn.remove(0);
                pn.remove(0);
            } else {
                answer+=pn.get(0);
                pn.remove(0);
            }
        }
        while(!nn.isEmpty()) {
            if(nn.size()>1) {
                answer+=nn.get(0)*nn.get(1);
                nn.remove(0);
                nn.remove(0);
            } else {
                answer+=nn.get(0);
                nn.remove(0);
            }
        }
        System.out.println(answer);
    }
}
