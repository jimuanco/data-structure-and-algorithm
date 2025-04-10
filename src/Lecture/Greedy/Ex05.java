package Lecture.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    public int vex;
    public int cost;
    Edge(int vex, int cost) {
        this.vex=vex;
        this.cost=cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost-o.cost;
    }
}

//다익스트라 알고리즘 -> 그래프 간선의 가중치 값이 음수이면 안됨
public class Ex05 {
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b,c));
        }
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1,0));
        dis[1]=0;
        while(!pQ.isEmpty()) {
            Edge tmp=pQ.poll(); //logN(이진트리), cost 젤 작은 값 poll()
            int now=tmp.vex;
            int nowCost=tmp.cost;
            if(nowCost>dis[now]) continue;
            for(Edge ob : graph.get(now)) {
                if(dis[ob.vex]>nowCost+ob.cost) {
                    dis[ob.vex]=nowCost+ob.cost;
                    pQ.offer(new Edge(ob.vex,nowCost+ob.cost));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=n; i++) {
            if(dis[i]!=Integer.MAX_VALUE) sb.append(i+" : "+dis[i]+"\n");
            else sb.append(i+" : impossible"+"\n");
        }
        System.out.println(sb);
    }
}
