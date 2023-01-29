package Baekjoon.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//여행 가자
//분리 집합 = 서로소 집합
public class Ex1976 {
    public static int[] unf;
    public static int Find(int v) {
        if(v==unf[v]) return v;
        else return unf[v]=Find(unf[v]);
    }
    public static void Union(int a, int b) {
        int fa=Find(a);
        int fb=Find(b);
        if(fa!=fb) unf[fa]=fb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        int [][] graph = new int[n+1][n+1];
        unf = new int[n+1];
        for(int i=1; i<=n; i++) unf[i]=i;
        StringTokenizer st;
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                graph[i][j]=Integer.parseInt(st.nextToken());
                if(graph[i][j]==1) {
                    Union(i,j);
                }
            }
        }
        int[] trip = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            trip[i]=Integer.parseInt(st.nextToken());
        }
        String answer="YES";
        for(int i=0; i<m-1; i++) {
            int fv1=Find(trip[i]);
            int fv2=Find(trip[i+1]);
            if(fv1==fv2) continue;
            else {
                answer="NO";
                break;
            }
        }
        System.out.println(answer);
    }
}
