package Review.Lecture2025.Recursive_Tree_Graph_DFS_BFS_basic;

// 팩토리얼
public class Ex03_a {
    public static void main(String[] args) {
        System.out.print(DFS(5));
    }

    private static int DFS(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * DFS(n - 1);
        }
    }
}
