package Lecture.Recursive_Tree_Graph_DFS_BFS_basic;

//재귀함수(스택프레임)
public class Ex01 {

    public void DFS(int n) {
        if(n==0) return;
        else {
            DFS(n-1);
            System.out.print(n+" ");
        }
    }

    public void solution(int n) {
        DFS(n);
    }

    public static void main(String[] args) {
        Ex01 T = new Ex01();
        T.solution(3);
    }
}
