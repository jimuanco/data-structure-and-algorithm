package Study;

public class thisTest {

    int n;

    void solution(int n) {
        this.n = n;
        System.out.println(this.n);
    }

    public static void main(String[] args) {
        thisTest test = new thisTest();
        test.solution(3);
    }
}
