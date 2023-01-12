package Lecture.Recursive_Tree_Graph_DFS_BFS_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//그래프 최단거리(BFS) -> 레벨로 풀어도 되지만 배열로 풀어(2차원배열로 푸는문제도 있음)
public class Ex14 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;
    public void BFS(int v) {
        dis[v]=0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        while(!queue.isEmpty()) {
            int cv=queue.poll();
            for(int nv : graph.get(cv)) {
                if(ch[nv]==0) {
                    ch[nv]=1;
                    queue.offer(nv);
                    dis[nv]=dis[cv]+1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Ex14 T = new Ex14();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        ch=new int[n+1];
        dis=new int[n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        ch[1]=1;
        T.BFS(1);
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=n; i++) {
            sb.append(i+ " : "+dis[i] + "\n");
        }
        System.out.println(sb);
    }
}
