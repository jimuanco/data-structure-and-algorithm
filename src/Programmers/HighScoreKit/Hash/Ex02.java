package Programmers.HighScoreKit.Hash;

//완주하지 못한 선수(Lv1)
/*
participant	completion	return
["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
 */

import java.util.*;

class Ex02 {
    public static void main(String[] args) {
        String[] participant={"leo","kiki","eden"};
        String[] completion={"eden","kiki"};
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<completion.length; i++) {
            map.put(completion[i],map.getOrDefault(completion[i],0)+1);
        }
        for(int i=0; i<participant.length; i++) {
            if(map.containsKey(participant[i])) {
                map.put(participant[i],map.get(participant[i])-1);
                if(map.get(participant[i])==0) map.remove(participant[i]);
            } else {
                System.out.println(participant[i]);
                return;
            }
        }
        System.out.println(answer);;
    }
}
