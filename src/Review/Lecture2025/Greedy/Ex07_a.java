package Review.Lecture2025.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 원더랜드(최소스패닝트리 : 크루스칼, Union&Find 활용) -> 모두 연결된 트리를 뽑아냈을때 간선의 가중치 값의 합이 최소가 되게
// 회로 존재o -> 그래프, 회로 존재x -> 트리(간선 갯수=정점 갯수-1)
/*
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15
 */
public class Ex07_a {
    static int[] unf;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        unf = new int[n + 1];
        List<Edge> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) unf[i] = i;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new Edge(a, b, c));
        }
        int answer = 0;
        arr.sort(Comparator.comparingInt(o -> o.cost));
        int cnt = 0;
        for (Edge o : arr) {
            if (cnt == n - 1) break;
            int fv1 = Find(o.v1);
            int fv2 = Find(o.v2);
            if (fv1 != fv2) {
                answer += o.cost;
                Union(o.v1, o.v2);
                cnt++;
            }
        }
        System.out.println(answer);
    }

    private static class Edge {
        int v1, v2, cost;
        Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }

    private static int Find(int v) {
        if(v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    private static void Union(int a, int b) {
        int fa = Find(a), fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }
}
