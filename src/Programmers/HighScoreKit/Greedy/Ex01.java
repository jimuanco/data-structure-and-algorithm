package Programmers.HighScoreKit.Greedy;

import java.util.*;

//체육복(Lv1)
/*
n	lost	reserve	return
5	[2, 4]	[1, 3, 5]	5
5	[2, 4]	[3]	4
3	[3]	[1]	2
 */
class Ex01 {
    public static void main(String[] args) {
        int n=5;
        int[] lost={2,4};
        int[] reserve={1,3,5};
        int answer = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int[] arr=new int[n+1];
        for(int i=0; i<lost.length; i++) {
            arr[lost[i]]=-1;
        }
        for(int i=0; i<reserve.length; i++) {
            if(arr[reserve[i]]==-1) { //본인 체육복을 도난당했으면 본인++
                arr[reserve[i]]++;
                continue;
            }
            if(reserve[i]-1!=0 && arr[reserve[i]-1]==-1) arr[reserve[i]-1]++;
                //바로 뒷번호 학생이 체육복을 도난 당했지만 그 학생이 여벌의 체육복을 가지고 있다면 빌려주면 안됨
            else if(i+1<reserve.length && reserve[i]+1==reserve[i+1] && arr[reserve[i]+1]==-1) continue;
            else if(reserve[i]+1<=n && arr[reserve[i]+1]==-1) arr[reserve[i]+1]++;
        }
        for(int i=1; i<=n; i++) {
            if(arr[i]!=-1) answer++;
        }
        System.out.println(answer);
    }
}