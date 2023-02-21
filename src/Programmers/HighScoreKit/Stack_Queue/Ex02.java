package Programmers.HighScoreKit.Stack_Queue;

import java.util.*;

//기능 개발(Lv2)
/*
progresses	speeds	return
[93, 30, 55]	[1, 30, 5]	[2, 1]
[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
 */
class Info {
    int pro,sp;
    Info(int pro, int sp) {
        this.pro=pro;
        this.sp=sp;
    }
}

class Ex02 {
    public static void main(String[] args) {
        int[] progresses={93,30,55};
        int[] speeds={1,30,5};
        int[] answer = {};
        Queue<Info> Q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            Q.offer(new Info(progresses[i],speeds[i]));
        }
        ArrayList<Integer> arr = new ArrayList<>();
        int day=0, cnt=0;
        while(!Q.isEmpty()) {
            Info tmp=Q.poll();
            if((100-tmp.pro)%tmp.sp==0) {
                if(day<(100-tmp.pro)/tmp.sp) {
                    day=(100-tmp.pro)/tmp.sp;
                    arr.add(cnt);
                    cnt=1;
                } else {
                    cnt++;
                }
            } else {
                if(day<(100-tmp.pro)/tmp.sp+1) {
                    day=(100-tmp.pro)/tmp.sp+1;
                    arr.add(cnt);
                    cnt=1;
                } else {
                    cnt++;
                }
            }
        }
        arr.add(cnt);
        answer = new int[arr.size()-1];
        for(int i=1; i<arr.size(); i++) {
            answer[i-1]=arr.get(i);
        }
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }
}