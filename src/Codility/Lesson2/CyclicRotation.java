package Codility.Lesson2;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
Example test:   ([3, 8, 9, 7, 6], 3)
OK

Example test:   ([0, 0, 0], 1)
OK

Example test:   ([1, 2, 3, 4], 4)
OK
 */
class CyclicRotation {
    public static void main(String[] args) {
        int[] A = {3, 8, 9, 7, 6};
        int K = 3;
        for(int i=0; i<K; i++) {
            for(int j=A.length-1; j>=1; j--) {
                int tmp=A[j];
                A[j]=A[j-1];
                A[j-1]=tmp;
            }
        }
        for(int x : A) {
            System.out.print(x + " ");
        }
    }
}