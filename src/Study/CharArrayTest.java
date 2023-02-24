package Study;

public class CharArrayTest {
    public static void main(String[] args) {
        char[][] arr={{'a','b','c'},{'d','e','f'}};
        char tmp=arr[0][0];
        System.out.println(tmp);
        arr[0][0]=arr[0][1];
        System.out.println(arr[0][0]);
        arr[0][0]=tmp;
        System.out.println(arr[0][0]);
    }
}
