package Study;

public class testtest {
    public static void main(String[] args) {
        System.out.println(1 ^ 5); //4
        System.out.println(1 ^ 9); //8

        System.out.println(9 ^ 5); //12
        System.out.println(9 ^ 9); //0

        System.out.println(5 ^ 5); //0
        System.out.println(5 ^ 9); //12

        System.out.println(13 ^ 5); //8
        System.out.println(13 ^ 9); //4

        System.out.println(Integer.toString(5,2));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(5^9));

        System.out.println("=============");
    }
}
