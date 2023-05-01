package Study;

public class BinaryString2 {
    public static void main(String[] args) {
        String binary = Long.toBinaryString(5);
        System.out.println(binary);
        int height = (int) Math.ceil(Math.log10(binary.length()+1) / Math.log10(2));
        System.out.println(height);
    }
}
