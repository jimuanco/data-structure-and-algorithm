package Review.Lecture2025.Recursive_Tree_Graph_DFS_BFS_basic;

// 부분집합 구하기(DFS) -> 상태트리
public class Ex06_a {
    static int n;
    static int[] ch;
    public static void main(String[] args) {
        n = 3;
        ch = new int[n + 1];
        DFS(1);
    }

    private static void DFS(int L) {
        if (L == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp += (i + " ");
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;

        }
    }
}
