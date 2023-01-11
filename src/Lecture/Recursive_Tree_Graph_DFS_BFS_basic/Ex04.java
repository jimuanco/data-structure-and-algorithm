package Lecture.Recursive_Tree_Graph_DFS_BFS_basic;

//피보나치 재귀(메모이제이션) -> for문 배열로 짜는게 성능이 더 좋음 (재귀는 스택프레임땜에 메모리낭비, 무거움)
public class Ex04 {
    public int DFS(int n) {
        if(n==1) return 1;
        else if(n==2) return 1;
        else return DFS(n-2)+DFS(n-1);
    }

    public static void main(String[] args) {
        Ex04 T = new Ex04();
        int n=45;
        for(int i=1; i<=n; i++) System.out.print(T.DFS(i)+" ");
    }
}

class Ex04_2 {
    static int[] fibo;
    public int DFS(int n) {
        if(n==1) return fibo[n]=1;
        else if(n==2) return fibo[n]=1;
        else return fibo[n]=DFS(n-2)+DFS(n-1);
    }

    public static void main(String[] args) {
        Ex04_2 T = new Ex04_2();
        int n=45;
        fibo= new int[n+1];
        T.DFS(n);
        for(int i=1; i<=n; i++) System.out.print(fibo[i]+" ");
    }
}

class Ex04_3 {
    static int[] fibo;
    public int DFS(int n) {
        if(fibo[n]>0) return fibo[n];
        if(n==1) return fibo[n]=1;
        else if(n==2) return fibo[n]=1;
        else return fibo[n]=DFS(n-2)+DFS(n-1);
    }

    public static void main(String[] args) {
        Ex04_3 T = new Ex04_3();
        int n=45;
        fibo=new int[n+1];
        T.DFS(n);
        for(int i=1; i<=n; i++) System.out.print(fibo[i]+" ");
    }

}
