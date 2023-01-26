package Baekjoon.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

//단순하게 풀면 1000 x 1000 + 재귀함수로 시간 초과
//벽 부수고 이동하기 4
public class Ex16946 {
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int n,m,rKey=1,rVal=0;
    static int[][] road,road2;

    public static int DFS(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m && road[nx][ny]==0) {
                road[nx][ny]=rKey;
                rVal++;
                DFS(nx,ny);
            }
        }
        return rVal;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        road = new int[n][m];
        road2 = new int[n][m];
        for(int i=0; i<n; i++) { //띄어쓰기 없는 2차원 int 배열 받을 때
            String input = br.readLine();
            char[] ch = input.toCharArray();
            for(int j=0; j<m; j++) {
//                road[i][j]=Integer.parseInt(String.valueOf(ch[j]));
                road[i][j]=ch[j]-'0';
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(road[i][j]==0) {
                    rKey++;
                    rVal++;
                    road[i][j]=rKey;
                    int rVal=DFS(i,j);
                    map.put(rKey,rVal);
                }
                rVal=0;
            }
        }
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(road[i][j]==1) {
                    for(int k=0; k<4; k++) {
                        int nx=i+dx[k];
                        int ny=j+dy[k];
                        if(nx>=0 && nx<n && ny>=0 && ny<m && road[nx][ny]!=0 && road[nx][ny]!=1) {
                            set.add(road[nx][ny]);
                        }
                    }
                    int tmp=0;
                    for(int x : set) {
                        tmp+=map.get(x);
                    }
                    road2[i][j]=(tmp+1)%10;
                }
                set = new TreeSet<>();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int[] x : road2) {
            for(int y : x) {
                sb.append(y);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
