package Programmers.HighScoreKit.Hash;

//전화번호 목록(Lv2)
/*
phone_book	return
["119", "97674223", "1195524421"]	false
["123","456","789"]	true
["12","123","1235","567","88"]	false
 */
import java.util.*;

class Ex03_a2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<phone_book.length; i++) {
            map.put(phone_book[i],i);
        }
        for(int i=0; i<phone_book.length; i++) {
            for(int j=0; j<phone_book[i].length(); j++) {
                if(map.containsKey(phone_book[i].substring(0,j))) { //Length 1부터 j(전체 길이-1)까지 있는지 확인
                    return false;
                }
            }
        }
        return answer;
    }
}