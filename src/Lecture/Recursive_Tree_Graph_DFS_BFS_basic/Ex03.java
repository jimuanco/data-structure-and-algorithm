package Lecture.Recursive_Tree_Graph_DFS_BFS_basic;

//팩토리얼
public class Ex03 {
    public int DFS(int n) {
        if(n==1) return 1;
        else return n*DFS(n-1);
    }

    public static void main(String[] args) {
        Ex03 T = new Ex03();
        System.out.print(T.DFS(5));
    }
}
