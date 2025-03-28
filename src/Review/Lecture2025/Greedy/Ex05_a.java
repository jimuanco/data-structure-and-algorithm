package Review.Lecture2025.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 다익스트라 알고리즘 -> 그래프 간선의 가중치 값이 음수이면 안됨
/*
6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5
 */
public class Ex05_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
        }
        PriorityQueue<Edge> pQ = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        pQ.offer(new Edge(1, 0));
        dis[1] = 0;
        while(!pQ.isEmpty()) {
            Edge tmp =  pQ.poll(); // logN(이진트리), cost 젤 작은 값 poll()
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if (nowCost > dis[now]) continue;
            for (Edge ob :  graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (dis[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + dis[i]);
            } else {
                System.out.println(i + " : impossible");
            }
        }
    }

    private static class Edge {
        int vex, cost;
        Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
    }
}
