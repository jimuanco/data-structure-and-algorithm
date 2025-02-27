package Review.Lecture2025.Recursive_Tree_Graph_DFS_BFS_basic;

// 피보나치 재귀(메모이제이션)
public class Ex04_a {
    public static void main(String[] args) {
        int n = 45;
        for (int i = 1; i <= n; i++) {
            System.out.print(DFS1(i) + " ");
        }
    }

    private static int DFS1(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 1;
        else return DFS1(n - 2) + DFS1(n - 1);
    }

    private static class Ex04_2 {
        static int[] fibo;
        public static void main(String[] args) {
            int n = 45;
            fibo = new int[n + 1];
            DFS2(n);
            for (int i = 1; i <= n; i++) {
                System.out.print(fibo[i] +  " ");
            }
        }

        private static int DFS2(int n) {
            if (fibo[n] > 0) return fibo[n];
            if (n == 1) return fibo[n] = 1;
            else if (n == 2) return fibo[n] = 1;
            else return fibo[n] = DFS2(n - 2) + DFS2(n - 1);
        }
    }
}
