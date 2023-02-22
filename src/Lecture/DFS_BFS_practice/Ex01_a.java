package Lecture.DFS_BFS_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//합이 같은 부분집합(DFS : 아마존 인터뷰)
//Baekjoon Ex1182(부분수열의 합)과 비슷한 유형
public class Ex01_a {
    static String answer="NO";
    static int n, total=0;
    boolean flag=false;
    public void DFS(int L, int sum, int[] arr) {
        if(flag) return;
        if(sum>total/2) return;
        if(L==n) {
            if((total-sum)==sum) {
                answer="YES";
                flag=true;
            }
        } else {
            DFS(L+1,sum+arr[L],arr);
            DFS(L+1,sum,arr);
        }
    }

    public static void main(String[] args) throws IOException {
        Ex01_a T = new Ex01_a();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total+=arr[i];
        }
        T.DFS(0,0,arr);
        System.out.println(answer);
    }
}
