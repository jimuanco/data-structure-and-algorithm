package Programmers.HighScoreKit.BinarySearch;

import java.util.*;

//입국심사(Lv3)
/*
n	times	return
6	[7, 10]	28
 */
class Ex01_a {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        long answer = 0;
        Arrays.sort(times);
        long lt=0;
        long rt=(long)n*times[times.length-1]; //가장 오래 걸리는 시간
        while(lt<=rt) {
            long mid=(lt+rt)/2;
            long sum=0; //총 심사한 인원
            for(int i=0; i<times.length; i++) {
                sum+=mid/times[i];
            }
            if(sum>=n) {
                answer=mid;
                rt=mid-1;
            } else {
                lt=mid+1;
            }
        }
        System.out.println(answer);
    }
}