package Study;

public class BinaryString {
    public static void main(String[] args) {
        int n = 5;
        String a = Integer.toBinaryString(9);
        int c = Integer.parseInt(a);
        String b = String.format("%0"+n+"d",c);
//        System.out.println(b);
        for(char x : b.toCharArray()) {
            System.out.print(x+" ");
        }
    }
}
