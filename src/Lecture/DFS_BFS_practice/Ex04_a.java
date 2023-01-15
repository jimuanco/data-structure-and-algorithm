package Lecture.DFS_BFS_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//중복순열
public class Ex04_a {
    static int[] pm;
    static int n, m;

    public static void DFS(int L){
        if(L==m) {
            for(int x : pm) System.out.print(x+" ");
            System.out.println();

        } else {
            for(int i=1; i<=n; i++) {
                pm[L]=i;
                DFS(L+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pm = new int[m];
        DFS(0);
    }
}
