package Review.Lecture.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge3 implements Comparable<Edge3> {
    public int vex,cost;
    Edge3(int vex, int cost) {
        this.vex=vex;
        this.cost=cost;
    }
    @Override
    public int compareTo(Edge3 ob) {
        return this.cost-ob.cost;
    }
}

//원더랜드(최소스패닝트리 : 프림, PriorityQueue)
public class Ex08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Edge3>> graph=new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge3(b,c));
            graph.get(b).add(new Edge3(a,c));
        }
        int[] ch = new int[n+1];
        int answer=0;
        PriorityQueue<Edge3> pQ = new PriorityQueue<>();
        pQ.offer(new Edge3(1,0));
        while(!pQ.isEmpty()) {
            Edge3 tmp=pQ.poll();
            int ev=tmp.vex;
            if(ch[ev]==0) {
                ch[ev]=1;
                answer+=tmp.cost;
                for(Edge3 ob : graph.get(ev)) {
                    if(ch[ob.vex]==0) pQ.offer(ob);
                }
            }
        }
        System.out.println(answer);
    }
}
