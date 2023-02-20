package Programmers.HighScoreKit.DFS_BFS;

import java.util.*;

//네트워크(Lv3)
/*
n	computers	return
3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
 */
class Ex02 {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    static void DFS(int v) {
        for(int nv : graph.get(v)) {
            if(visited[nv]==0) {
                visited[nv]=1;
                DFS(nv);
            }
        }
    }

    public static void main (String[] args) {
        int n=3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        int answer = 0;
        graph = new ArrayList<>();
        visited=new int[n+1];
        for(int i=0; i<=computers.length; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<computers.length; i++) {
            for(int j=0; j<computers[i].length; j++) {
                if(computers[i][j]==1) {
                    graph.get(i+1).add(j+1);
                }
            }
        }
        for(int i=1; i<=n; i++) {
            if(graph.get(i).isEmpty()) { //비어있다면 어차피 방문한적이 없기 때문에 answer++ 후 continue
                answer++;
                continue;
            }
            if(visited[i]==1) continue; //이미 방문한적이 있으면 continue
            visited[i]=1;
            answer++;
            DFS(i);
        }
        System.out.println(answer);;
    }
}
