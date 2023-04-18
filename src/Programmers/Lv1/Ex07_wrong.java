package Programmers.Lv1;

//둘만의 암호(Lv1)
//TC 1,2,9,14,15만 통과

import java.util.*;

class Ex07_wrong {
    public String solution(String s, String skip, int index) {
        String answer = "";
        ArrayList<Character> arr = new ArrayList<>();
        for(int i=0; i<skip.length(); i++) {
            arr.add(skip.charAt(i));
        }

        for(int i=0; i<s.length(); i++) {
            int tmp = s.charAt(i)+index;
            for(char x : arr) {
                if(x>=s.charAt(i) && x<=tmp) {
                    tmp++;
                }else if(tmp>122) {
                    int tmp2 = tmp;
                    while(tmp2>122) {
                        tmp2=tmp2-26;
                    }
                    if(x<=tmp2) {
                        tmp++;
                    }
                }
            }
            while(tmp>122) {
                tmp=tmp-26;
            }
            answer+=(char)tmp;
        }
        return answer;
    }
}