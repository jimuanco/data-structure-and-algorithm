package Lecture.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//친구인가(Union&Find) -> Disjoint-Set(서로소 집합) 외워!
public class Ex06 {
    static int[] unf;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        unf = new int[n+1];
        for(int i=1; i<=n; i++) unf[i]=i;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            Union(a,b);
        }
        st = new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int fa=Find(a);
        int fb=Find(b);
        if(fa==fb) System.out.println("YES");
        else System.out.println("NO");
    }
}
