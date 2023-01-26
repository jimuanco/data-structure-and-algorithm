package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//영역 구하기
public class Ex2583 {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int n,m,area=0,cnt=0;
    static int[][] graph;
    public static void DFS(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<m && ny>=0 && ny<n && graph[nx][ny]==0) {
                graph[nx][ny]=1;
                area++;
                DFS(nx,ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        graph=new int[m][n];
        int k=Integer.parseInt(st.nextToken());
        int[][] co=new int[k][4];
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++) {
                co[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<k; i++) {
            int a =co[i][0]; // 0
            int b =m-co[i][1]-1; //2
            int c =m-co[i][3]; //1
            int d =co[i][2]-1; //3
            for(int j=0; j<m; j++) {
                for(int s=0; s<n; s++) {
                    if(j>=c && j<=b && s>=a && s<=d) {
                        graph[j][s]=1;
                    }
                }
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(graph[i][j]==0) {
                    graph[i][j]=1;
                    area++;
                    cnt++;
                    DFS(i,j);
                    arr.add(area);
                    area=0;
                }
            }
        }
        Collections.sort(arr);
        StringBuilder sb= new StringBuilder();
//        System.out.println(cnt);
        sb.append(cnt+"\n"); // '\n' 이 아니라 "\n"
        for(int x : arr) {
            sb.append(x+" ");
        }
        System.out.println(sb);
    }
}
