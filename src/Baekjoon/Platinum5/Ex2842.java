package Baekjoon.Platinum5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

//집배원 한상덕
public class Ex2842 {
    static int[] dx={-1,-1,0,1,1,1,0,-1};
    static int[] dy={0,1,1,1,0,-1,-1,-1};
    static int n,cnt,lt,rt;
    static int[][] visited, height, town;
    static ArrayList<Integer> arr;
    public static void DFS(int x, int y) {
        for(int i=0; i<8; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && visited[nx][ny]==0 && arr.get(lt)<=height[nx][ny] && arr.get(rt)>=height[nx][ny]) {
                visited[nx][ny]=1;
                if(town[nx][ny]=='K') {
                    cnt--;
                }
                DFS(nx,ny);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        town = new int[n][n];
        height = new int[n][n];
        visited = new int[n][n];
        int px=0,py=0;
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            char[] ch = input.toCharArray();
            for(int j=0; j<n; j++) {
                town[i][j]=ch[j];
                if(ch[j]=='K') {
                    cnt++;
                }
                if(ch[j]=='P') {
                    px=i;
                    py=j;
                }
            }
        }
        StringTokenizer st;
        TreeSet<Integer> set = new TreeSet<>();
        int rtMax=Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int h=Integer.parseInt(st.nextToken());
                height[i][j]=h;
                set.add(h);
                if(town[i][j]=='K' || town[i][j]=='P') {
                    rtMax=Math.max(h,rtMax);
                }
            }
        }
        arr = new ArrayList<>(set);
        lt=0;
        rt=arr.indexOf(rtMax);
        int answer=Integer.MAX_VALUE;
        int nk=cnt;
        while(rt<arr.size() && lt<=rt && lt<=arr.indexOf(height[px][py])) {
            DFS(px,py);
            if(cnt==0) {
                answer=Math.min(arr.get(rt)-arr.get(lt),answer);
                lt++;
            } else {
                rt++;
            }
            cnt=nk;
            visited = new int[n][n];
        }
        System.out.println(answer);
    }
}
