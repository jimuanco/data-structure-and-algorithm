package Programmers.Lv1;

//2022 KAKAO TECH INTERNSHIP
//성격 유형 검사하기(lv1)
/*
survey	choices	result
["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	"TCMA"
["TR", "RT", "TR"]	[7, 1, 3]	"RCJA"
 */
import java.util.*;

class Ex03 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
        for(int i=0; i<choices.length; i++) {
            if(choices[i]==1) {
                map.put(survey[i].charAt(0),map.get(survey[i].charAt(0))+3);
            }
            else if(choices[i]==2) {
                map.put(survey[i].charAt(0),map.get(survey[i].charAt(0))+2);
            }
            else if(choices[i]==3) {
                map.put(survey[i].charAt(0),map.get(survey[i].charAt(0))+1);
            }
            else if(choices[i]==5) {
                map.put(survey[i].charAt(1),map.get(survey[i].charAt(1))+1);
            }
            else if(choices[i]==6) {
                map.put(survey[i].charAt(1),map.get(survey[i].charAt(1))+2);
            }
            else if(choices[i]==7) {
                map.put(survey[i].charAt(1),map.get(survey[i].charAt(1))+3);
            }
        }
        answer += map.get('R') >= map.get('T') ? 'R' : 'T';
        answer += map.get('C') >= map.get('F') ? 'C' : 'F';
        answer += map.get('J') >= map.get('M') ? 'J' : 'M';
        answer += map.get('A') >= map.get('N') ? 'A' : 'N';
        return answer;
    }
}