package Lecture.DFS_BFS_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//조합 구하기 (외워)
public class Ex09_a {
    static int[] combi;
    static int n, m;
    public static void DFS(int L, int s) {
        if(L==m) {
            for(int x : combi) System.out.print(x+" ");
            System.out.println();
        } else {
            for(int i=s; i<=n; i++) {
                combi[L]=i;
                DFS(L+1,i+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        combi = new int[m];
        DFS(0,1);
    }
}
