package Codility.Lesson4;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
Example test:   (5, [3, 4, 4, 6, 1, 4, 4])
OK
 */

/*
Detected time complexity:
O(N + M)
 */
class MaxCounters_2 {
    public int[] solution(int N, int[] A) {
        int[] answer = new int[N];
        int max=0, max2=0;
        for(int i=0; i<A.length; i++) {
            if(A[i]!=N+1) {
                if(answer[A[i]-1]<max2) {
                    answer[A[i]-1]=max2+1;
                    max=Math.max(max,max2+1);
                } else {
                    answer[A[i]-1]++;
                    max=Math.max(max,answer[A[i]-1]);
                }
            } else {
                max2=max;
            }
        }
        for(int i=0; i<N; i++) {
            if(answer[i]<max2) {
                answer[i]=max2;
            }
        }
        return answer;
    }
}

