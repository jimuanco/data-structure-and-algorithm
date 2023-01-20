package Baekjoon.Platinum5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//다시 하자..
//집배원 한상덕
public class Ex2842_incomplete2 {
    static int[] dx={-1,-1,0,1,1,1,0,-1};
    static int[] dy={0,1,1,1,0,-1,-1,-1};
    static int n, lt, rt, cnt=0;
    static int[][] height, visited, point;
    static ArrayList<Integer> arr;
    static char[][] map;
    public static void DFS(int x, int y) {
        for(int i=0; i<8; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && visited[nx][ny]==0) {
                visited[nx][ny]=1;
                if(lt==rt) {
                    lt =Math.min(lt,point[nx][ny]);
                    rt =Math.max(rt,point[nx][ny]);
                } else if(lt>point[nx][ny]) {
                    lt=point[nx][ny];
                } else if(rt<point[nx][ny]) {
                    rt=point[nx][ny];
                }
                if(map[nx][ny]=='K') {
                    cnt--;
                }
                if(cnt==0) {
                    cnt++;
                    System.out.println(arr.get(rt)-arr.get(lt));
                    return;
                }
                DFS(nx,ny);
                visited[nx][ny]=0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        map = new char[n][n];
        height = new int[n][n];
        visited = new int[n][n];
        point = new int[n][n];
        int px=0, py=0;
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            char[] ch = input.toCharArray();
            for(int j=0; j<n; j++) {
                map[i][j]=ch[j];
                if(ch[j]=='P') {
                   px=i;
                   py=j;
                }
                if(ch[j]=='K') {
                    cnt++;
                }
            }
        }
        arr = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int k=Integer.parseInt(st.nextToken());
                height[i][j]=k;
                if(!arr.contains(k)) {
                    arr.add(k);
                }
            }
        }
        Collections.sort(arr);
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                point[i][j]=arr.indexOf(height[i][j]);
            }
        }
        lt=point[px][py];
        rt=point[px][py];
        DFS(px,py);
    }
}
