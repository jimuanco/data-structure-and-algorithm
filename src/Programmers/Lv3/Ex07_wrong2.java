package Programmers.Lv3;

//부대복귀(lv3)
/*
n	roads	sources	destination	result
3	[[1, 2], [2, 3]]	[2, 3]	1	[1, 2]
5	[[1, 2], [1, 4], [2, 4], [2, 5], [4, 5]]	[1, 3, 5]	5	[2, -1, 0]
 */

/*
2 ≤ roads의 길이 ≤ 500,000
1 ≤ sources의 길이 ≤ 500
500,000 * 500 -> 재귀로 풀면 당연 시간초과
다익스트라(그래프 간선의 가중치 값이 음수이면 안됨), 플로이드워셜 써야 함
 */

/*
다익스트라 썼는데 TC 11~15 시간 초과 (잘못씀)
 */

import java.util.*;

//class Edge implements Comparable<Edge> {
//    int vex;
//    int cost;
//    Edge(int vex, int cost) {
//        this.vex=vex;
//        this.cost=cost;
//    }
//    @Override
//    public int compareTo(Edge ob) {
//        return this.cost-ob.cost;
//    }
//}

class Ex07_wrong2 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            graph.get(a).add(new Edge(b,1));
            graph.get(b).add(new Edge(a,1));
        }
        PriorityQueue<Edge> pQ;
        for(int i=0; i<sources.length; i++) {
            int[] dis = new int[n+1];
            Arrays.fill(dis,Integer.MAX_VALUE);
            pQ = new PriorityQueue<>();
            pQ.offer(new Edge(sources[i],0));
            dis[sources[i]]=0;
            while(!pQ.isEmpty()) {
                Edge tmp = pQ.poll();
                int now = tmp.vex;
                int nowCost = tmp.cost;
                if(nowCost>dis[now]) continue;
                for(Edge ob : graph.get(now)) {
                    if(dis[ob.vex]>nowCost+ob.cost) {
                        dis[ob.vex]=nowCost+ob.cost;
                        pQ.offer(new Edge(ob.vex, nowCost+ob.cost));
                    }
                }
            }
            if(dis[destination] == Integer.MAX_VALUE) {
                answer[i]=-1;
            } else {
                answer[i]=dis[destination];
            }
        }
        return answer;
    }
}
