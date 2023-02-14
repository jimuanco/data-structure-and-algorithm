package Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//트리
//int[] visited 없어도 됨
public class Ex1068 {
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
                Q.offer(nv);
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rootNode = 0;
        int[] arr=new int[n];
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        delNode=Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            if(arr[i]!=-1 && arr[i]!=delNode && i!=delNode) {
                graph.get(arr[i]).add(i);
            }
            if(arr[i]==-1) rootNode=i;
        }
        int answer = BFS(rootNode);
        System.out.println(answer);
    }
}
