package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//단지번호붙이기
public class Ex2667 {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int n,complex,house;
    static int[][] graph, visited;
    public static void DFS(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && graph[nx][ny]==1 && visited[nx][ny]==0) {
                visited[nx][ny]=1;
                complex++;
                DFS(nx,ny);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new int[n][n];
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            char[] ch = input.toCharArray();
            for(int j=0; j<n; j++) {
                graph[i][j]=ch[j]-'0';
            }
        }
//        TreeSet<Integer> set = new TreeSet<>(); //중복제거하면 안되니 TreeSet 쓰지마
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(graph[i][j]==1 && visited[i][j]==0) {
                    visited[i][j]=1;
                    complex++;
                    house++;
                    DFS(i,j);
//                    set.add(complex);
                    arr.add(complex);
                    complex=0;
                }
            }
        }
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        sb.append(house+"\n"); // '\n' 이 아니라 "\n"
        for(int x : arr) {
            sb.append(x+"\n");
        }
        System.out.println(sb);
    }
}
