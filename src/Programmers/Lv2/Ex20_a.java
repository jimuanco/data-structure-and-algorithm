package Programmers.Lv2;

//연습문제
//숫자 변환하기

/*
x	y	n	result
10	40	5	2
10	40	30	1
2	5	4	-1
 */

//BFS로 풀기

import java.util.*;

class Ex20_a {
    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 5;

        if(x==y) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[y+1];
        Queue<Integer> Q = new LinkedList<>();

        Q.offer(x);
        while(!Q.isEmpty()) {
            int num = Q.poll();

            int[] tmp = new int[3];
            tmp[0] = num + n;
            tmp[1] = num * 2;
            tmp[2] = num * 3;

            for(int result : tmp) {
                if(result > y) continue;

                if(arr[result] == 0 || arr[result] > arr[num] + 1) {
                    arr[result] = arr[num] + 1;
                    Q.offer(result);
                }
            }
        }

        System.out.println(arr[y] != 0 ? arr[y] : -1);
    }
}