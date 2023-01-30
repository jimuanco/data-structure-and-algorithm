package Lecture.HashMap_TreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//아나그램(해쉬)
//길이가 같다는 조건 고려 안함..이렇게 풀지말고 풀이대로 풀어
public class Ex02 {
    public String solution(String s1, String s2) {
        String answer="YES";
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char x : s1.toCharArray()) {
            map1.put(x, map1.getOrDefault(x, 0)+1);
        }
        for(char x : s2.toCharArray()) {
            map2.put(x, map2.getOrDefault(x, 0)+1);
        }
        if(map1.size() == map2.size()) {
            for(char x : map1.keySet()) {
                if(!map2.containsKey(x) || map1.get(x)!=map2.get(x)) answer="NO";
            }
        } else {
            answer="NO";
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex02 T = new Ex02();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        System.out.println(T.solution(s1, s2));
    }
}
