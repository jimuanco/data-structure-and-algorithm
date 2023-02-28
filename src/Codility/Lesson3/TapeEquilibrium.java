package Codility.Lesson3;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
/*
Example test:   [3, 1, 2, 4, 3]
OK
 */
class TapeEquilibrium {
    public int solution(int[] A) {
        int answer=Integer.MAX_VALUE;
        int lt=0;
        int rt=Arrays.stream(A).sum();
        for(int i=0; i<A.length-1; i++) {
            lt+=A[i];
            rt-=A[i];
            answer=Math.min(answer,Math.abs(lt-rt));
        }
        return answer;
    }
}
