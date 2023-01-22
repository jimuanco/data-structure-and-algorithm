package Baekjoon.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//빙산
public class Ex2573 {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int n,m,iceArea=0,numIceArea=0,answer,numIceArea2;
    static int[][] ice, visited, ice2;
    static boolean flag=false;
    public static int DFS(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=1 && nx<n-1 && ny>=1 && ny<m-1 && ice[nx][ny]!=0 && visited[nx][ny]==0) {
                visited[nx][ny]=1;
                iceArea++;
                for(int j=0; j<4; j++) {
                    int chx=nx+dx[j];
                    int chy=ny+dy[j];
                    if(ice[chx][chy]==0) ice2[nx][ny]--;
                }
                if(ice2[nx][ny]<=0) {
                    ice2[nx][ny]=0;
                    numIceArea2--;
                }
//                if(ice2[nx][ny]==0) {
//                    numIceArea2--;
//                }
                DFS(nx,ny);
            }
        }
        return iceArea;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ice = new int[n][m];
        ice2 = new int[n][m];
        visited = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                int h=Integer.parseInt(st.nextToken());
                ice[i][j]=h;
                ice2[i][j]=h;
                if(h!=0){
                    numIceArea++;
                    numIceArea2++;
                }
            }
        }
        while(true) {
            if(flag) break;
            for(int i=1; i<n-1; i++) {
                if(flag) break;
                for(int j=1; j<m-1; j++) {
                    if(ice[i][j]!=0 && visited[i][j]==0) {
                        iceArea++;
                        visited[i][j]=1;
                        for(int k=0; k<4; k++) {
                            int chx=i+dx[k];
                            int chy=j+dy[k];
                            if(ice[chx][chy]==0) ice2[i][j]--;
                        }
                        if(ice2[i][j]<=0) {
                            ice2[i][j]=0;
                            numIceArea2--;
                        }
//                        if(ice2[i][j]==0) {
//                            numIceArea2--;
//                        }
                        int num = DFS(i,j);
                        if(num==numIceArea) answer++;
                        else {
                            flag=true;
                            break;
                        }
                        iceArea=0;
                    }
                }
            }
            visited = new int[n][m];
            numIceArea=numIceArea2;
            int chOne=0;
            for(int i=1; i<n-1; i++) {
                for(int j=1; j<m-1; j++) {
                    ice[i][j]=ice2[i][j];
                    if(ice[i][j]==0) {
                        chOne++;
                    }
                }
            }
            if(chOne==(n-2)*(m-2)) {
                answer=0;
                break;
            }
        }
        System.out.println(answer);
    }
}
