package Programmers.HighScoreKit.Sort;

//H-Index(Lv2)
/*
citations	return
[3, 0, 6, 1, 5]	3
 */
import java.util.*;

class Ex03_a {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int answer = 0;
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (o1, o2) -> o2-o1);
        for(int i=0; i<arr.length; i++) {
            if(i+1==arr[i]) {
                System.out.println(i+1);
                return;
            }
            if(i+1>arr[i]) {
                System.out.println(i);
                return;
            }
        }
        answer=arr.length;
        System.out.println(answer);
    }
}