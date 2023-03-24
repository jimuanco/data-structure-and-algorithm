package Programmers.HighScoreKit.ExhaustiveSearch;

//전력망을 둘로 나누기(lv2)
/*
n	wires	result
9	[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]	3
4	[[1,2],[2,3],[3,4]]	0
7	[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]	1
 */

import java.util.*;

class Ex06 {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    static int check = 0;

    static void DFS(int v) {
        for (int nv : graph.get(v)) {
            if (visited[nv] == 0) {
                visited[nv] = 1;
                check++;
                DFS(nv);
            }
        }
    }

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int answer = Integer.MAX_VALUE;

        //n이 최대 100밖에 안되므로 전선을 하나씩 제외 해가며 따져 본다.
        int cnt = 0;
        while (cnt < wires.length) {

            //(주의!) graph 매 번 새로 new 해줘야 함
            graph = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            visited = new int[n + 1];

            for (int i = 0; i < wires.length; i++) {

                //전선을 하나씩 제외
                if (cnt == i) continue;
                int[] wire = wires[i];
                graph.get(wire[0]).add(wire[1]);
                graph.get(wire[1]).add(wire[0]);
            }

            check = 1;
            visited[1] = 1;
            DFS(1);

            //두 전력망이 가지고 있는 송전탑 개수의 차이가 최소인게 answer
            answer = Math.min(Math.abs((n - check) - check), answer);

            //answer = 0 이면 바로 끝낸다.
            if (answer == 0) {
                System.out.println(0);
                return;
            }

            cnt++;
        }
        System.out.println(answer);
    }
}
