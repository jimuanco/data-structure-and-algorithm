package Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//부분수열의 합
//Lecture,DFS_BFS_practice.Ex01(//합이 같은 부분집합(DFS : 아마존 인터뷰))과 비슷한 유형
//Baekjoon Ex1208(부분수열의 합2)에서 N값만 40->20
//N이 작아 재귀를 이용한 백트래킹으로 풀 수 있음
public class Ex1182 {
    static int n,m,answer=0;
    static int[] arr;
    static void DFS(int L, int sum) {
        if(L==n) {
            if(sum==m) {
                answer++;
            }
        } else {
            DFS(L+1,sum+arr[L]);
            DFS(L+1,sum);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        DFS(0,0);
        if(m==0) answer--; //재귀함수가 돌며 아무것도 더하지 않는 경우의 수 고려(sum이 0에서 시작하기 때문)
        System.out.println(answer);
    }
}

//브루트포스 알고리즘
//백트래킹