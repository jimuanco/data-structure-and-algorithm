package Review.Lecture2025.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최대점수 구하기(냅색 알고리즘, 가방 문제) -> N이 50까지라 DFS로 풀 수 없음 (DFS_BFS_practice Ex03 참조)
// dy[j] -> j분동안 얻을 수 있는 최대점수
// 종류가 무한개면 j가 앞에서 부터 증가, 유한개면 j가 뒤에서 부터 감소
// Baekjoon Ex12865와 같은 유형
/*
5 20
10 5
25 12
15 8
6 3
7 4
 */
public class Ex06_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dy = new int[m + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int ps = Integer.parseInt(st.nextToken());
            int pt = Integer.parseInt(st.nextToken());
            for (int j = m; j >= pt; j--) {
                dy[j] = Math.max(dy[j], dy[j - pt] + ps);
            }
        }
        System.out.println(dy[m]);
    }
}
