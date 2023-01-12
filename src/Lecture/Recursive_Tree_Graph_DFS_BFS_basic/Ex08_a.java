package Lecture.Recursive_Tree_Graph_DFS_BFS_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//송아지 찾기1(BFS) -> 최단거리 알고리즘(최소 횟수~)
public class Ex08_a {
    int answer=0;
    int[] dis={1,-1,5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int s, int e) {
        ch = new int[10001];
        ch[s]=1;
        Q.offer(s);
        int L=0;
        while(!Q.isEmpty()) {
            int len=Q.size();
            for(int i=0; i<len; i++) {
                int x=Q.poll();
                for(int j=0; j<dis.length; j++) {
                    int nx=x+dis[j];
                    if(nx==e) return L+1;
                    if(nx>=1 && nx<=10000 && ch[nx]==0) {
                        ch[nx]=1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Ex08_a T = new Ex08_a();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        System.out.println(T.BFS(s, e));
    }
}
