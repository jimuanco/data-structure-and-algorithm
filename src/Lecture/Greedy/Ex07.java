package Lecture.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//원더랜드(최소스패닝트리 : 크루스칼, Union&Find 활용) -> 모두 연결된 트리를 뽑아냈을때 간선의 가중치 값의 합이 최소가 되게
//회로 존재o -> 그래프, 회로 존재x -> 트리(간선 갯수=정점 갯수-1)
class Edge2 implements Comparable<Edge2> {
    public int v1;
    public int v2;
    public int cost;
    Edge2(int v1, int v2, int cost) {
        this.v1=v1;
        this.v2=v2;
        this.cost=cost;
    }
    @Override
    public int compareTo(Edge2 o) {
        return this.cost-o.cost;
    }
}
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        unf=new int[n+1];
        ArrayList<Edge2> arr = new ArrayList<>();
        for(int i=1; i<=n; i++) unf[i]=i;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            arr.add(new Edge2(a,b,c));
        }
        int answer=0;
        Collections.sort(arr);
        int cnt=0;
        for(Edge2 o : arr) {
            if(cnt==n-1) break; //간선의 갯수가 많을때 해줘야 함.
            int fv1=Find(o.v1);
            int fv2=Find(o.v2);
            if(fv1!=fv2) {
                answer+=o.cost;
                Union(o.v1,o.v2);
                cnt++;
            }
        }
        System.out.println(answer);
    }
}
