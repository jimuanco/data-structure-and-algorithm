package Lecture.DFS_BFS_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//순열 구하기
public class Ex06_a {
    static int n, m;
    static int[] pm;

    public static void DFS(int L, int[] arr, int[] ch) {
        if(L==m) {
            for(int x : pm) {
                System.out.print(x+" ");
            }
            System.out.println();
        } else {
            for(int i=0; i<n; i++) {
                if(ch[i]==0) {
                    pm[L]=arr[i];
                    ch[i]=1;
                    DFS(L+1,arr,ch);
                    ch[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pm = new int[m];
        int[] arr = new int[n];
        int[] ch = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        DFS(0,arr,ch);
    }
}
