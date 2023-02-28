package Codility.Lesson2;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
Example test:   [9, 3, 9, 3, 9, 7, 9]
OK
 */
class OddOccurrencesInArray_2 {
    public int solution(int[] A) {
        int answer=0;
        Arrays.sort(A);
        for(int i=0; i<A.length-1;) {
            if(A[i]==A[i+1]) {
                i+=2;
            } else {
                return A[i];
            }
        }
        answer=A[A.length-1];
        return answer;
    }
}