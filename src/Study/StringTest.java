package Study;

public class StringTest {
    public static void main(String[] args) {
        String str = "hit";
        String str2 = "hot";
        System.out.println(str.indexOf(str2.charAt(2)));
        for(char x : str2.toCharArray()) {
            System.out.println(str.indexOf(x));
        }
    }
}
