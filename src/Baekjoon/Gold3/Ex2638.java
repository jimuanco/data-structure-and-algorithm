package Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//치즈
public class Ex2638 {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int n,m,ch,numAir=0,time=0;
    static int[][] graph, air;
    public static void DFS(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m && graph[nx][ny]==0 && air[nx][ny]==0) {
                air[nx][ny]=1;
                numAir++;
                DFS(nx,ny);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        graph=new int[n][m];
        air=new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        while(true) {
            air[0][0]=1;
            numAir++;
            DFS(0,0);
            if(numAir==n*m) {
                break;
            } else {
                numAir=0;
            }
            for(int i=1; i<n-1; i++) {
                for(int j=1; j<m-1; j++) {
                    ch=0;
                    for(int k=0; k<4; k++) {
                        int nx=i+dx[k];
                        int ny=j+dy[k];
                        if(nx>=0 && nx<n && ny>=0 && ny<m && air[nx][ny]==1) {
                            ch++;
                        }
                        if(ch==2) {
                            graph[i][j]=0;
                            break;
                        }
                    }
                }
            }
            time++;
            air = new int[n][m];
        }
        System.out.println(time);
    }
}
