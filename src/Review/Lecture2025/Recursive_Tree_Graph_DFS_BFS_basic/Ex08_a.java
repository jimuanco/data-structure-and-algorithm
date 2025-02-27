package Review.Lecture2025.Recursive_Tree_Graph_DFS_BFS_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 송아지 찾기1(BFS) -> 최단거리 알고리즘(최소 횟수~)
// 5 14
// 답이 더 깔끔
public class Ex08_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[] dis = {1, -1, 5};
        int[] ch = new int[10001];
        Queue<Integer> Q = new LinkedList<>();

        ch[s] = 1;
        Q.offer(s);
        int L = 0;
        boolean flag = false;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                for (int j = 0; j < dis.length; j++) {
                    int nx = x + dis[j];
                    if (nx == e) {
                        L++;
                        flag = true;
                        break;
                    }
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }

                }
                if (flag) break;
            }
            if (flag) break;
            L++;
        }
        System.out.println(L);
    }
}
