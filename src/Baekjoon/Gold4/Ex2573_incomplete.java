package Baekjoon.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//실패..
//빙산
public class Ex2573_incomplete {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int n,m,chSea=0, chOne=0, ch;
    static int[][] ice, visited, ice2;
    public static void DFS(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m && ice[nx][ny]!=0 && visited[nx][ny]==0) {
                visited[nx][ny]=1;
                for(int j=0; j<4; j++) {
                    int chx=nx+dx[j];
                    int chy=ny+dy[j];
                    if(ice[chx][chy]==0) ice2[nx][ny]-=1;
                }
                if(ice2[nx][ny]<0) ice2[nx][ny]=0;
                chSea=0;
                DFS(nx,ny);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        ice = new int[n][m];
        ice2 = new int[n][m];
        visited = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                int h=Integer.parseInt(st.nextToken());
                ice[i][j]=h;
                ice2[i][j]=h;
            }
        }
        while(true) {
            if(ch==4) break;
            int i=1;
            int j=1;
            for( ; i<n-1; i++) {
                for(; j<m-1; j++) {
                    if(ice[i][j]!=0 && visited[i][j]==0) {
                        visited[i][j]=1;
                        for(int s=0; s<4; s++) {
                            int chx=i+dx[s];
                            int chy=j+dy[s];
                            if(ice[chx][chy]==0) ice2[i][j]-=1;
                        }
                        if(ice2[i][j]<0) ice2[i][j]=0;
                        chSea=0;
                        DFS(i,j);
                    }
                }
            }
            chOne++;
            for(int p=0; p<n; i++) {
                if(ch==4) break;
                for(int q=0; q<m; q++) {
                    for(int r=0; r<4; r++) {
                        if(ice[p][q]!=0) {
                            int nx=ice2[p][q]+dx[r];
                            int ny=ice2[p][q]+dx[r];
                            if(nx>0 && nx<n && ny>=0 && ny<m && ice2[nx][ny]==0) {
                                ch++;
                            }
                        }
                    }
                    if(ch==4) {
                        break;
                    } else {
                        ch=0;
                    }
                }
            }
//            ice=ice2.clone();
            for(int k=0; k<n; k++) {
                for(int l=0; l<m; l++) {
                    ice[k][l]=ice2[k][l];
                }
            }
            visited=new int[n][m];
        }
        System.out.println(chOne);
    }
}
