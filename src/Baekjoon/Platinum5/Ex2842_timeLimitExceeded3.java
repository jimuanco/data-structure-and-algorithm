package Baekjoon.Platinum5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//집배원 한상덕
public class Ex2842_timeLimitExceeded3 {
    static int[] dx={-1,-1,0,1,1,1,0,-1};
    static int[] dy={0,1,1,1,0,-1,-1,-1};
    static int n, cnt=0, ltV, rtV;
    static int[][] visited, height;
    static char[][] map;

    static boolean flag=false;

    public static void DFS(int x, int y) {
        if(flag==true) return;
        for(int i=0; i<8; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && visited[nx][ny]==0 && height[nx][ny]>=ltV && height[nx][ny]<=rtV) {
                visited[nx][ny]=1;
                if(map[nx][ny]=='K') {
                    cnt--;
                }
                if(cnt==0) {
                    flag=true;
                    return;
                }
                DFS(nx,ny);
                if(map[nx][ny]=='K') {
                    cnt++;
                }
                visited[nx][ny]=0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        map = new char[n][n];
        int px=0,py=0;
        ltV=Integer.MAX_VALUE;
        rtV=Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            char[] ch = input.toCharArray();
            for(int j=0; j<n; j++) {
                map[i][j]=ch[j];
                if(ch[j]=='P') {
                    px=i;
                    py=j;
                }
            }
        }
        height = new int[n][n];
        visited = new int[n][n];
        StringTokenizer st;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                height[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]=='P' || map[i][j]=='K') {
                    cnt++;
                    ltV=Math.min(height[i][j],ltV);
                    rtV=Math.max(height[i][j],rtV);
                }
                if(!arr.contains(height[i][j])) {
                    arr.add(height[i][j]);
                }
            }
        }
        cnt--;
        int kn=cnt;
        Collections.sort(arr);
        int lt,rt;
        lt=arr.indexOf(ltV);
        rt=arr.indexOf(rtV);
        int answer=Integer.MAX_VALUE;
        while(rt!=arr.size() && lt>=0) {
            rtV=arr.get(rt);
            ltV=arr.get(lt);
            DFS(px,py);
            if(flag) {
                answer=Math.min(rtV-ltV,answer);
            }
            visited = new int[n][n];
            flag=false;
            cnt=kn;
            if(rt<arr.size()) {
                rt++;
            } else {
                lt--;
            }
        }
        System.out.println(answer);
    }
}
