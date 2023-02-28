package Codility.Lesson1;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
N=1041, 15, 32
 */
class BinaryGap {
    public static void main(String[] args) {
        int N = 1041;
        int answer=0;
        String binaryString = Integer.toBinaryString(N);
        // System.out.print(binaryString);
        int cnt=0;
        for(char x : binaryString.toCharArray()) {
            if(x=='0') {
                cnt++;
            } else {
                answer=Math.max(answer,cnt);
                cnt=0;
            }
        }
        System.out.println(answer);;
    }
}
