package Codility.Lesson4;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
Example test:   (5, [1, 3, 1, 4, 2, 3, 5, 4])
OK
 */
class FrogRiverOne {
    public int solution(int X, int[] A) {
        int answer=0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<A.length; i++) {
            set.add(A[i]);
            if(set.size()==X) {
                return i;
            }
        }
        answer=-1;
        return answer;
    }
}
