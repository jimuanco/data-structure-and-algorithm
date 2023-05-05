package Study;

public class RecurTest {
    static int cnt=0;
    public static void main(String[] args) {
        DFS(0);
        System.out.println("cnt: " + cnt);
    }
    static void DFS(int x) {
        x++;
        System.out.println(x);
        if(x==5) {
            cnt++;
            return;
        }
        DFS(x);
        System.out.println("얌");
//        DFS(x);
    }
}
