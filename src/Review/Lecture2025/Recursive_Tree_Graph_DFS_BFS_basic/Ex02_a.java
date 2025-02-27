package Review.Lecture2025.Recursive_Tree_Graph_DFS_BFS_basic;

// 이진수 출력(재귀)
public class Ex02_a {
    public static void main(String[] args) {
        int x = 11;
        System.out.println(Integer.toString(x, 2));
        DFS(x);

    }

    private static void DFS(int n) {
        if (n > 0) {
            DFS(n / 2);
            System.out.print(n % 2);
        }
    }
}
