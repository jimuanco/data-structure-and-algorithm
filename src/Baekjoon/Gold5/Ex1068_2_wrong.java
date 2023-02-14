package Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//트리

//반례
//3
//-1 0 1
//2
//답은 1인데 0뜸
public class Ex1068_2_wrong {
    static int[] visited;
    static int delNode;
    static ArrayList<ArrayList<Integer>> graph;
    static int BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v);
        int cnt=0;
        while(!Q.isEmpty()) {
            int cv=Q.poll();
            if(cv==delNode) continue;
            if(graph.get(cv).isEmpty()) cnt++;
            for(int nv : graph.get(cv)) {
                if(visited[nv]==0) {
                    visited[nv]=1;
                    Q.offer(nv);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        visited = new int[n];
        graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rootNode = 0;
        for(int i=0; i<n; i++) {
            int Node=Integer.parseInt(st.nextToken());
            if(Node!=-1) {
                graph.get(Node).add(i);
            } else rootNode=i;
        }
        delNode=Integer.parseInt(br.readLine());
        visited[rootNode]=1;
        int answer = BFS(rootNode);
        System.out.println(answer);
    }
}
