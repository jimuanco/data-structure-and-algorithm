package Baekjoon.Platinum5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//DFS+이분탐색으로 풀려했으나 실패..
//집배원 한상덕
public class Ex2842_incomplete {
    static int[] dx={-1,-1,0,1,1,1,0,-1};
    static int[] dy={0,0,1,1,0,-1,-1,-1};
    static int n, mid, cnt=1;
    static int[][] height, visited, ch;
    static ArrayList<ArrayList<Integer>> arrKP;
    static boolean flag=false;
    public static void DFS(int x, int y) {
        for(int i=0; i<8; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && visited[nx][ny]==0) {
                visited[nx][ny]=1;
                ch[nx][ny]=height[nx][ny];
                if(arrKP.get(nx).contains(ny)) {
                    cnt++;
                }
                if(arrKP.size()==cnt) {
                    for(int j=0; j<n; j++) {
                        for(int k=0; k<n; k++) {
                            
                        }
                    }
                }
                DFS(nx,ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map = new int[n][n];
        height = new int[n][n];
        visited = new int[n][n];
        ch = new int[n][n];
        arrKP = new ArrayList<>();
        for(int i=0; i<n; i++) {
            arrKP.add(new ArrayList<>());
        }
        int px=0 ,py=0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]=='K') {
                    arrKP.get(i).add(j);
                }
                if(map[i][j]=='P') {
                    arrKP.get(i).add(j);
                    px=i;
                    py=j;
                    visited[i][j]=1;
                }
            }
        }
        int maxK=Integer.MIN_VALUE;
        int minK=Integer.MAX_VALUE;
        int maxH=Integer.MIN_VALUE;
        int minH=Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int k=Integer.parseInt(st.nextToken());
                if(arrKP.get(i).contains(j)) {
                    maxK=Math.max(k,maxK);
                    minK=Math.min(k,minK);
                }
                if(i==px && j==py) {
                    ch[i][j]=k;
                }
                maxH=Math.max(k,maxH);
                minH=Math.max(k,minH);
                height[i][j]=k;
            }
        }
        int lt=maxK-minK;
        int rt=maxH-minH;
        int answer=0;
        while(lt<=rt) {
            if(lt==rt) {
                answer=lt-rt;
                break;
            }
            mid=(lt+rt)/2;
            DFS(px,py);
        }
        System.out.println(answer);
    }
}
