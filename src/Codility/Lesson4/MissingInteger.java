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
//88점
//Timeout Error
//chaotic + sequence 1, 2, ..., 40000 (without minus) -> running time: 1.140 sec., time limit: 0.944 sec.
class MissingInteger {
    public int solution(int[] A) {
        int answer=0;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<A.length; i++) {
            if(A[i]>0) {
                set.add(A[i]);
            }
        }
        for(int x : set) {
            answer++;
            if(answer!=x) {
                return answer;
            }
        }
        answer++;
        return answer;
    }
}