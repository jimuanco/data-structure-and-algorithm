package Study;

public class IntTest {
    public static void main(String[] args) {
        int test = 011;
//        System.out.println(test);
        int[] arr={0,1,1};
        String strNum="";
        for(int x : arr) {
            strNum+=x;
        }
        System.out.println(strNum);
        System.out.println(strNum.charAt(0)=='0');
        System.out.println(Integer.parseInt(strNum));
    }
}
