package Programmers.Lv1;

//카드 뭉치(Lv1)

/*
마지막(TC 25) 틀림
->카드를 사용하지 않고 넘어갈 수 없다
 */

import java.util.*;

class Ex08_wrong {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<goal.length; i++) {
            map.put(goal[i],i);
        }
        int idx = 0;
        for(int i=0; i<cards1.length; i++) {
            if(!map.containsKey(cards1[i])) continue;
            int val = map.get(cards1[i]);
            if(idx>val) {
                return "No";
            }
            idx = val;
            map.remove(cards1[i]);
        }
        idx = 0;
        for(int i=0; i<cards2.length; i++) {
            if(!map.containsKey(cards2[i])) continue;
            int val = map.get(cards2[i]);
            if(idx>val) {
                return "No";
            }
            idx = val;
            map.remove(cards2[i]);
        }
        if(map.size()!=0) return "No";
        return answer;
    }
}