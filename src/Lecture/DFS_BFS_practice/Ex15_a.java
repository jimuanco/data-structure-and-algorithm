package Lecture.DFS_BFS_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//class Point {
//    public int x, y;
//    Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}

//피자배달거리(DFS)
public class Ex15_a {

    static int m,len;
    static int[] combi;
    static int answer=Integer.MAX_VALUE;
    static ArrayList<Point> hs, pz;

    public static void DFS(int L, int s) {
        if(L==m) {
            int sum=0;
            for(Point h : hs) {
                int dis=Integer.MAX_VALUE;
                for(int i : combi) {
                    dis=Math.min(dis, Math.abs(h.x-pz.get(i).x)+Math.abs(h.y-pz.get(i).y));
                }
                sum+=dis;
            }
            answer=Math.min(sum,answer);
        } else {
            for(int i=s; i<len; i++) {
                combi[L]=i;
                DFS(L+1,i+1); //i말고 s로 하면 시간 초과 뜸
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pz = new ArrayList<>();
        hs = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp==1) hs.add(new Point(i,j));
                else if(tmp==2) pz.add(new Point(i,j));
            }
        }
        len=pz.size();
        combi=new int[m];
        DFS(0,0);
        System.out.println(answer);
    }
}
