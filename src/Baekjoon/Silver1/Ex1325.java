package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//효율적인 해킹
public class Ex1325 {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int cnt, n;
    static int max=Integer.MIN_VALUE;
    public static void DFS(int v) {
        for(int nv : graph.get(v)) {
            if(cnt==n) return;
            if(ch[nv]==0) {
                cnt++;
                ch[nv]=1;
                DFS(nv);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph=new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        ch=new int[n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            graph.get(b).add(a);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            if(graph.get(i).isEmpty()) continue;
            cnt=1;
            ch[i]=1;
            DFS(i);
            ch=new int[n+1];
            if(cnt>max) {
                max=cnt;
                sb.setLength(0);
                sb.append(i);
            } else if(cnt==max) {
                sb.append(" "+i);
            }
            cnt=0;
        }
        System.out.println(sb);
    }
}
