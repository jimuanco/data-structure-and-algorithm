package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//정수 삼각형
//재귀함수 사용
public class Ex1932_a {
    static int[][] arr;
    // DP를 쓸 때 Integer라는 객체를 통해 객체배열로 활용
    // 이유는 int[] 배열로 쓰면 0이라는 값이 default(디폴트)로 초기화가 되어있는데 문제에서 주어진 값의 범위가 0~9999으로 0이 겹침
    // 물론 탐색 전에 -1같은 입력 범위 밖의 수들로 초기화 해주어도 되지만 그런 것보단 객체배열의 default값인 null을 활용하는게 좀 더 편함
    // 다만, 메모리가 초과될 수 있으니 이 점 유의
    // 기본적으로 Integer[] 배열은 int[] 배열의 4배정도의 메모리가 소모된다고 하니 자칫 재귀가 매우 깊어지거나 입력 값이 많은 경우에는 객체배열을 피하는게 좋음.
    static Integer[][] dp;
    static int n;
    static int recur(int depth, int idx) {
        // 마지막 행일 경우 현재 위치의 dp값 반환
        // if(dp[depth][idx]==null) 조건이 있어 굳이 안넣어도 되지만 탈출 조건이 어떻게 되는지 명확하게 하기 위함
        // 이 번 문제에서는 이미 N-1 인덱스에 초기값을 갖고있어 문제가 없지만 일반적으로는 탈출조건을 갖고있어야 안전하기 때문에 가독성 측면이나 안정성 측면에서도 일단 써주고 보는 것이 좋음.
        if(depth==n-1) return dp[depth][idx];
        // 탐색하지 않았던 값일 경우 다음 행의 양쪽 값 비교
        if(dp[depth][idx]==null) {
            dp[depth][idx]=Math.max(recur(depth+1,idx),recur(depth+1,idx+1))+arr[depth][idx];
        }
        return dp[depth][idx];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new int[n][n];
        dp=new Integer[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1; j++) { //j<i+1 주의!
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++) {
            dp[n-1][i]=arr[n-1][i];
        }
        System.out.println(recur(0,0));
    }
}
