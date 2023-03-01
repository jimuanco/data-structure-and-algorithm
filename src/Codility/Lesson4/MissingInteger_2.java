package Codility.Lesson4;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
Example test:   [1, 3, 6, 4, 1, 2]
OK

Example test:   [1, 2, 3]
OK

Example test:   [-1, -3]
OK

Your test case: [1, 3, 5, 4, 1, 2]
Returned value: 6
 */

//O(N) or O(N * log(N))
//1과 비교시
//chaotic + sequence 1, 2, ..., 40000 (without minus) -> 0.276s OK
class MissingInteger_2 {
    public int solution(int[] A) {
        int answer=0;
        Arrays.sort(A);
        for(int i=0; i<A.length-1; i++) {
            if(A[i]>0 && A[i]!=A[i+1]) {
                answer++;
                if(answer!=A[i]) {
                    return answer;
                }
            }
        }
        answer++;
        if(answer!=A[A.length-1]) return answer;
        answer++;
        return answer;
    }
}