package Programmers.HighScoreKit.DFS_BFS;

//여행경로(Lv3)
/*
tickets	return
[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
 */

import java.util.*;

class Ex06_a {
    static int[] visited;
    static ArrayList<String> allRoute;

    static void DFS(String start, String route, String[][] tickets, int cnt) {
        if(cnt == tickets.length) {
            allRoute.add(route);
            return;
        }

        for(int i=0; i<tickets.length; i++) {
            if(start.equals(tickets[i][0]) && visited[i]==0) {
                visited[i]=1;
                DFS(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
                visited[i]=0;
            }
        }
    }

    public static void main(String[] args) {
        String[] answer = {};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        int cnt = 0;
        visited = new int[tickets.length];
        allRoute = new ArrayList<>();

        DFS("ICN", "ICN", tickets, cnt);

        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");

        for(String str : answer) {
            System.out.print(str+" ");
        }
    }
}
