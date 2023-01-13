package Lecture.DFS_BFS_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//바둑이 승차(DFS)
public class Ex02 {
    static int c,n,max=0;
    static int[] arr;

    public static void DFS(int L, int sum) {
        if(sum>c) return;
        if(L==n) {
            if(sum<=c) max=Math.max(max,sum); //여기 if는 없어도 돼(위에 if가 있으니)
        } else {
            DFS(L+1,sum+arr[L]);
            DFS(L+1,sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }
        DFS(0,0);
        System.out.println(max);
    }
}
