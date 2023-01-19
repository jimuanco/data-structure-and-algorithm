package Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//트리의 부모 찾기
public class Ex11725 {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public static void DFS(int v) {
        for(int nv : graph.get(v)) {
            if(ch[nv]==0) {
                ch[nv]=v;
                DFS(nv);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        ch=new int[n+1];
        StringTokenizer st;
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        ch[1]=1;
        DFS(1);
        for(int i=2; i<=n; i++) {
            System.out.println(ch[i]);
        }
    }
}
