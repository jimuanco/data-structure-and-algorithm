package Programmers.Lv2;

//무인도 여행(Lv2)
/*
maps	result
["X591X","X1X5X","X231X", "1XXX1"]	[1, 1, 27]
["XXX","XXX","XXX"]	[-1]
 */
import java.util.*;

class Ex06 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] visited;
    static int days;

    static void DFS(int x, int y, int n, int m, String[] maps) {
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m && maps[nx].charAt(ny) != 'X' && visited[nx][ny]==0) {
                visited[nx][ny]=1;
                days+=maps[nx].charAt(ny)-48;
                DFS(nx,ny,n,m,maps);
            }
        }
    }

    public static void main(String[] args) {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        int[] answer = {-1};
        int n = maps.length;
        int m = maps[0].length();
        visited = new int[n][m];
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(maps[i].charAt(j) != 'X' && visited[i][j]==0) {
                    days=maps[i].charAt(j)-48;
                    visited[i][j]=1;
                    DFS(i,j,n,m,maps);
                    arr.add(days);
                }
            }
        }
        Collections.sort(arr);
        if(!arr.isEmpty()) {
            answer = arr.stream().mapToInt(Integer::intValue).toArray();
        }
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }
}