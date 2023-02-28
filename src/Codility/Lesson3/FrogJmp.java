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
//Timeout Error
class FrogJmp {
    public int solution(int X, int Y, int D) {
        int answer=0;
        while(X<Y) {
            X+=D;
            answer++;
        }
        return answer;
    }
}
