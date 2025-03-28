package Review.Lecture2025.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 원더랜드(최소스패닝트리 : 프림, PriorityQueue)
/*
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15
 */
public class Ex08_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new  StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new  StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        int answer = 0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        pQ.offer(new Edge(1, 0));
        while(!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int ev = tmp.vex;
            if (ch[ev] == 0) {
                ch[ev] = 1;
                answer += tmp.cost;
                for (Edge o : graph.get(ev)) {
                    if (ch[o.vex] == 0) pQ.offer(o);
                }
            }
        }
        System.out.println(answer);
    }
    private static class Edge {
        int vex, cost;
        Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
    }
}
