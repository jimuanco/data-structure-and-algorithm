package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//안전 영역
public class Ex2468 {

    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int n, H, z;
    static int answer=Integer.MIN_VALUE;
    static int[][] board,dis;

    public static void DFS(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]>H && dis[nx][ny]==0) {
                dis[nx][ny]=1;
                DFS(nx,ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board=new int[n][n];
        ArrayList<Integer> arrH = new ArrayList<>();
        arrH.add(0); //이거 안넣어주면 틀림 (아무 지역도 물에 잠기지 않을 수도 있다.)
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int a =Integer.parseInt(st.nextToken());
                if(!arrH.contains(a)) arrH.add(a);
                board[i][j]=a;
            }
        }
        for(int i=0; i<arrH.size(); i++) {
            H = arrH.get(i);
            dis=new int[n][n];
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    if(H<board[j][k] && dis[j][k]==0) {
                        dis[j][k]=1;
                        DFS(j,k);
                        z++;
                    }
                }
            }
            answer=Math.max(answer,z);
            z=0;
        }
        System.out.println(answer);
    }
}
