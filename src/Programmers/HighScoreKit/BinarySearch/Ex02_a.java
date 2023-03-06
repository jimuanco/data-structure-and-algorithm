package Programmers.HighScoreKit.BinarySearch;

import java.util.*;

//징검다리(Lv4)
/*
distance	rocks	n	return
25	[2, 14, 11, 21, 17]	2	4
 */
class Ex02_a {
    static int count(int[] rocks, int mid, int distance) { //최소 거리 보다 더 짧으면 부셔라
        int cnt=0;
        int ep=0;
        for(int i=0; i<rocks.length; i++) {
            if(rocks[i]-ep<mid) {
                cnt++;
                continue;
            }
            ep=rocks[i];
        }
        if(distance-ep<mid) cnt++;
        return cnt;
    }
    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        int answer = 0;
        Arrays.sort(rocks);
        int lt=1;
        int rt=distance;
        while(lt<=rt) {
            int mid=(lt+rt)/2; //mid가 최소 거리
            //부순 갯수가 n보다 작거나 같으면 최소거리를 늘려라(lt=mid+1)
            if(count(rocks,mid,distance)<=n) {
                answer=mid;
                lt=mid+1;
            } else {
                rt=mid-1;
            }
        }
        System.out.println(answer);
    }
}