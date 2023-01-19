package Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//적록색약
public class Ex10026 {
    static char[][] graph,ch;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int n;
    public static void DFS1(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && ch[nx][ny]!='V') {
                if(graph[x][y]==graph[nx][ny]) {
                    ch[nx][ny]='V';
                    DFS1(nx,ny);
                }
            }
        }
    }
    public static void DFS2(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && ch[nx][ny]!='V') {
                if(graph[x][y]==graph[nx][ny]) {
                    ch[nx][ny]='V';
                    DFS2(nx,ny);
                } else if((graph[x][y]=='R' && graph[nx][ny]=='G') || (graph[x][y]=='G' && graph[nx][ny]=='R')) {
                    ch[nx][ny]='V';
                    DFS2(nx,ny);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        graph = new char[n][n];
        ch = new char[n][n];
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            char[] ch = input.toCharArray();
            for(int j=0; j<n; j++) {
                graph[i][j]=ch[j];
            }
        }
        int answer1=0;
        int answer2=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(ch[i][j]!='V' ) {
                    ch[i][j]='V';
                    DFS1(i,j);
                    answer1++;
                }
            }
        }
        ch = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(ch[i][j]!='V' ) {
                    ch[i][j]='V';
                    DFS2(i,j);
                    answer2++;
                }
            }
        }
        System.out.println(answer1+" "+answer2);
    }
}
