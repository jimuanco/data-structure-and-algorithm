package Programmers.HighScoreKit.Hash;

import java.util.*;

//포켓몬(Lv1)
/*
nums	result
[3,1,2,3]	2
[3,3,3,2,2,4]	3
[3,3,3,2,2,2]	2
 */
class Ex01 {
    public static void main(String[] args) {
        int[] nums={3,1,2,3};
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        if(map.size()>=nums.length/2) answer=nums.length/2; //최대 N/2마리
        else answer=map.size();
        System.out.println(answer);;
    }
}