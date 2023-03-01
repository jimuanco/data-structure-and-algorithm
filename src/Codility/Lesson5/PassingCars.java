package Codility.Lesson5;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
Example test:   [0, 1, 0, 1, 1]
OK

Your test case: [0, 1]
Returned value: 1
 */

//O(N)
class PassingCars {
    public int solution(int[] A) {
        int answer=0, countZero=0, countOne=0;
        for(int i=0; i<A.length; i++) {
            if(A[i]==0) countZero++;
            else countOne++;
        }
        for(int i=0; i<A.length; i++) {
            if(A[i]==0) {
                countZero--;
                answer+=A.length-(i+1)-countZero;
                if(answer>1000000000) return -1;
            }
        }
        return answer;
    }
}