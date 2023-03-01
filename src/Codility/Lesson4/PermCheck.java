package Codility.Lesson4;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
/*
Example test:   [4, 1, 3, 2]
OK

Example test:   [4, 1, 3]
OK
 */
class PermCheck {
    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        int max=0;
        for(int i=0; i<A.length; i++) {
            set.add(A[i]);
            max=Math.max(max,A[i]);
        }
        if(max!=A.length) {
            return 0;
        }
        if(set.size()==A.length) {
            return 1;
        }
        return 0;
    }
}
