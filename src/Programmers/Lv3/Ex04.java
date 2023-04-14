package Programmers.Lv3;

//2020 카카오 인턴십
//보석 쇼핑(Lv3)
/*
gems	result
["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]	[3, 7]
["AA", "AB", "AC", "AA", "AC"]	[1, 3]
["XYZ", "XYZ", "XYZ"]	[1, 1]
["ZZZ", "YYY", "NNNN", "YYY", "BBB"]	[1, 5]
 */

import java.util.*;

class Ex04 {
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        // int[] answer = {};
        int[] answer = new int[2];
        HashMap<String, Integer> map1 = new HashMap<>();
        for(int i=0; i<gems.length; i++) {
            map1.put(gems[i],map1.getOrDefault(gems[i],0)+1);
        }
        int idx=0, min=Integer.MAX_VALUE;
        HashMap<String, Integer> map2 = new HashMap<>();
        for(int i=0; i<gems.length; i++) {
            map2.put(gems[i],map2.getOrDefault(gems[i],0)+1);
            while(map2.size() == map1.size() && idx <= i) {
                if(i-idx<min) {
                    answer[0]=idx+1;
                    answer[1]=i+1;
                    min=i-idx;
                }
                map2.put(gems[idx],map2.get(gems[idx])-1);
                if(map2.get(gems[idx]) == 0) map2.remove(gems[idx]);
                idx++;
            }
        }
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }
}