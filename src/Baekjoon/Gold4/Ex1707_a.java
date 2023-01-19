package Baekjoon.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//이분 그래프
public class Ex1707_a {
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;
    static String answer;
    static boolean flag=false;
    public static void DFS(int v, int col) {
        if(flag) return;
        ch[v]=col;
        for(int nv : graph.get(v)) {
            if(ch[nv]==ch[v]) {
                flag=true;
                return;
            }
            if(ch[nv]==0) {
                DFS(nv,col*-1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<k; i++) {
            graph = new ArrayList<ArrayList<Integer>>();
            st = new StringTokenizer(br.readLine());
            int v=Integer.parseInt(st.nextToken());
            ch = new int[v+1];
            for(int vex=0; vex<=v; vex++) {
                graph.add(new ArrayList<>());
            }
            int e=Integer.parseInt(st.nextToken());
            for(int j=0; j<e; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            for(int vex=1; vex<=v; vex++) {
                if(ch[vex]==0) {
                    DFS(vex,1);
                }
            }
            if(flag) answer="NO";
            else answer="YES";
            sb.append(answer+"\n");
            flag=false;
        }
        System.out.println(sb);
    }
}

//이분 그래프 : 모든 정점을 두 가지 색으로 칠하되, 모든 간선이 두 가지 색의 정점을 포함하도록 색칠할 수 있는 그래프
//이분 그래프 판별:
//  1. 그래프를 BFS or DFS로 탐색하며, 색을 이웃과 다른 색으로 계속 칠한다.
//  2. 자신과 인접한 정점의 색이 자신과 같으면 이분 그래프가 아니다.
//
//  -연결 그래프일 경우, 정점 하나를 시작으로 탐색을 한 번만 마친 후, 판별할 수 있지만
//   비연결 그래프일 경우, 모든 정점을 탐색해 판별해야한다.


