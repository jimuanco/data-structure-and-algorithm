package Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//A → B

//DFS
//Lecture DFS_BFS_practice Ex05(동전교환)과 비슷한 유형
public class Ex16953 {
    static long b;
    static int answer=Integer.MAX_VALUE;
    static void DFS(int L, long a) {
        if(a>b) return;
        if(L>=answer) return;
        if(a==b) {
            answer=Math.min(answer,L);
        } else {
            DFS(L+1, a*2);
            DFS(L+1, a*10+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a=Long.parseLong(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        DFS(1, a);
        if(answer==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }
}
