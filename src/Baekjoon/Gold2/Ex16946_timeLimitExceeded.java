package Baekjoon.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1000 x 1000으로 시간 초과 다른 알고리즘 적용해야함
//벽 부수고 이동하기 4
public class Ex16946_timeLimitExceeded {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int n,m,nr=0;
    static int[][] road, visitedZero;

    public static int DFS(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m && road[nx][ny]==0 && visitedZero[nx][ny]==0) {
                visitedZero[nx][ny]=1;
                nr++;
                DFS(nx,ny);
            }
        }
        return nr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        road = new int[n][m];
        visitedZero = new int[n][m];
        for(int i=0; i<n; i++) { //띄어쓰기 없는 2차원 int 배열 받을 때
            String input = br.readLine();
            char[] ch = input.toCharArray();
            for(int j=0; j<m; j++) {
//                road[i][j]=Integer.parseInt(String.valueOf(ch[j]));
                road[i][j]=ch[j]-'0';
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(road[i][j]==1) {
                    nr++;
                    int nr=DFS(i,j);
//                    road[i][j]=nr; //배열 하나 추가로 만들 필요없고 기존 배열 바꿔서 for문으로 sb.append 하지말고 여기서 바로 하자
                    sb.append(nr);
                } else {
                    sb.append(0);
                }
                nr=0; //이걸 위의 if문안으로 넣으면 왜 안되지?
                visitedZero = new int[n][m];
            }
            sb.append('\n');
        }
        System.out.println(sb);
//        for(int[] x : road) {
//            for(int y : x) {
//                sb.append(y);
//            }
//            sb.append('\n');
//        }
//        System.out.println(sb);
    }
}
