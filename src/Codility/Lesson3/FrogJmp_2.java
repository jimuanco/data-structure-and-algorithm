package Codility.Lesson3;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
X = 10
Y = 85
D = 30
 */
class FrogJmp_2 {
    public int solution(int X, int Y, int D) {
        int answer=(int)Math.ceil((double)(Y-X)/D);
        return answer;
    }
}