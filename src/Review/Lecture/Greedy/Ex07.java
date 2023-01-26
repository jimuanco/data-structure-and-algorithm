package Review.Lecture.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    public int v1;
    public int v2;
    public int cost;
    Edge(int v1, int v2, int cost) {
        this.v1=v1;
        this.v2=v2;
        this.cost=cost;
    }
    @Override
    public int compareTo(Edge ob) {
        return this.cost-ob.cost;
    }
}

//원더랜드(최소스패닝트리 : 크루스칼, Union&Find 활용)
public class Ex07 {
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
        unf=new int[n+1];
        ArrayList<Edge> arr = new ArrayList<Edge>();
        for(int i=1; i<=n; i++) unf[i]=i;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            arr.add(new Edge(a,b,c));
        }
        int answer=0;
        Collections.sort(arr);
        int cnt=0;
        for(Edge ob : arr) {
            if(cnt==n-1) break;
            int fv1=Find(ob.v1);
            int fv2=Find(ob.v2);
            if(fv1!=fv2) {
                answer+=ob.cost;
                Union(ob.v1,ob.v2);
                cnt++;
            }
        }
        System.out.println(answer);
    }
}
