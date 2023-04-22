package Programmers.Lv3;

//부대복귀(lv3)
/*
n	roads	sources	destination	result
3	[[1, 2], [2, 3]]	[2, 3]	1	[1, 2]
5	[[1, 2], [1, 4], [2, 4], [2, 5], [4, 5]]	[1, 3, 5]	5	[2, -1, 0]
 */

/*
TC 6~15 시간 초과
2 ≤ roads의 길이 ≤ 500,000
1 ≤ sources의 길이 ≤ 500
500,000 * 500 -> 재귀로 풀면 당연 시간초과
다익스트라(그래프 간선의 가중치 값이 음수이면 안됨), 플로이드워셜 써야 함
 */
import java.util.*;

class Ex07_wrong {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    static int min;

    static void DFS(int v, int d, int s) {
        if(v==d) {
            min = Math.min(min, s);
        } else {
            for(int nv : graph.get(v)) {
                if(visited[nv]==0) {
                    visited[nv]=1;
                    DFS(nv,d,s+1);
                    visited[nv]=0;
                }
            }
        }
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i=0; i<sources.length; i++) {
            visited = new int[n+1];
            visited[sources[i]]=1;
            min = Integer.MAX_VALUE;
            DFS(sources[i],destination,0);
            if(min == Integer.MAX_VALUE) {
                answer[i]=-1;
            } else {
                answer[i]=min;
            }
        }
        return answer;
    }
}