package Programmers.HighScoreKit.Sort;

import java.util.*;

//K번째 수(Lv1)
/*
array	commands	return
[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
 */
class Ex01 {
    public static void main(String[] args) {
        int[] array={1,5,2,6,3,7,4};
        int[][] commands={{2,5,3},{4,4,1},{1,7,3}};
        int[] answer = {};
        answer=new int[commands.length];
        for(int i=0; i<commands.length; i++) {
            int[] command=commands[i]; //익히기!
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j=command[0]-1; j<command[1]; j++) {
                arr.add(array[j]);
            }
            Collections.sort(arr);
            answer[i]=arr.get(command[2]-1);
        }
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }
}