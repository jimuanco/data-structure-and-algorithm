package Programmers.Lv4;

import java.util.*;

//징검다리

//시간 초과됨
class Solution {
    static int[] combi;
    static int ans=0;
    static int count(int[] combi, long gap, int distance) {
        int cnt=1;
        int ep=0;
        for(int i=0; i<combi.length; i++) {
            if(combi[i]-ep>=gap) {
                cnt++;
                ep=combi[i];
            }
        }
        if(distance-ep>=gap) {
            cnt++;
        }
        return cnt;
    }
    static void DFS(int L, int s, int m, int[] rocks, int distance) {
        int val=0;
        if(L==m) {
            Arrays.sort(combi);
            int lt=0;
            int rt=distance;
            while(lt<=rt) {
                int mid=(lt+rt)/2;
                if(count(combi,mid,distance)>=combi.length+2) {
                    val=mid;
                    lt=mid+1;
                } else {
                    rt=mid-1;
                }
            }
            ans=Math.max(ans,val);
        } else {
            for(int i=s; i<rocks.length; i++) {
                combi[L]=rocks[i];
                DFS(L+1,i+1,m,rocks,distance);
            }
        }
    }

    public static void main(String[] args) {
        int distance=25;
        int[] rocks={2, 14, 11, 21, 17};
        int n=2;
        int answer = 0;
        int m=rocks.length-n;
        combi = new int[m];
        DFS(0, 0, m, rocks, distance);
        answer=ans;
        System.out.println(answer);;
    }
}
