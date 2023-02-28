package Codility.Lesson3;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
/*
Example test:   [2, 3, 1, 5]
OK

Your test case: []
Returned value: 1

Your test case: [1, 2, 3, 4]
Returned value: 5
 */
class PermMissingElem_2 {
    public int solution(int[] A) {
        Arrays.sort(A);
        for(int i=0; i<A.length; i++) {
            if(i+1!=A[i]) {
                return i+1;
            }
        }
        if(A.length==0) return 1;
        else return A.length+1;
    }
}
