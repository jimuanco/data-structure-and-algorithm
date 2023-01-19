package Lecture.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//원더랜드(최소스패닝트리 : 프림, PriorityQueue)

class Edge3 implements Comparable<Edge3> {
    public int vex;
    public int cost;
    Edge3(int vex, int cost) {
        this.vex=vex;
        this.cost=cost;
    }
    @Override
    public int compareTo(Edge3 o) {
        return this.cost-o.cost;
    }
}
public class Ex08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Edge3>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] ch = new int[n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge3(b,c));
            graph.get(b).add(new Edge3(a,c));
        }
        int answer=0;
        PriorityQueue<Edge3> pQ = new PriorityQueue<>();
        pQ.offer(new Edge3(1,0));
        while(!pQ.isEmpty()) {
            Edge3 tmp = pQ.poll(); //cost 작은거부터 poll
            int ev=tmp.vex;
            if(ch[ev]==0) { //회로방지(이미 트리에 포함된 정점은 제외)
                ch[ev]=1;
                answer+=tmp.cost;
                for(Edge3 o : graph.get(ev)) {
//                    if(ch[o.vex]==0) pQ.offer(new Edge3(o.vex,o.cost));
                    if(ch[o.vex]==0) pQ.offer(o);
                }
            }
        }
        System.out.println(answer);
    }
}
