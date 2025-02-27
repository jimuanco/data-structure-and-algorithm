package Review.Lecture2025.Recursive_Tree_Graph_DFS_BFS_basic;

// 재귀함수(스택프레임)
public class Ex01_a {
    public static void main(String[] args) {
        DFS(3);
    }

    private static void DFS(int n) {
        if (n > 0) {
            DFS(n - 1);
            System.out.print(n + " ");
        }
    }
}
