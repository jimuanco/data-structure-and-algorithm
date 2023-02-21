package Programmers.HighScoreKit.ExhaustiveSearch;

import java.util.*;

//모의고사
/*
answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
 */
class Ex02 {
    public static void main(String[] args) {
        int[] answers={1,2,3,4,5};
        int[] answer = {};
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        int[] count=new int[4];
        int idx1=0;
        int idx2=0;
        int idx3=0;
        for(int i=0; i<answers.length; i++) {
            if(a[idx1]==answers[i]) {
                count[1]+=1;
            }
            if(b[idx2]==answers[i]) {
                count[2]+=1;
            }
            if(c[idx3]==answers[i]) {
                count[3]+=1;
            }
            idx1++;
            idx2++;
            idx3++;
            if(idx1==a.length) idx1=0;
            if(idx2==b.length) idx2=0;
            if(idx3==c.length) idx3=0;
        }
        int max=Integer.MIN_VALUE;
        for(int i=1; i<=3; i++) {
            max=Math.max(max,count[i]);
        }
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=1; i<=3; i++) {
            if(count[i]==max) arr.add(i);
        }
        answer=new int[arr.size()];
        for(int i=0; i<arr.size(); i++) {
            answer[i]=arr.get(i);
        }
        for(int x : answer) {
            System.out.println(x);
        }
    }
}
