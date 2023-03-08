package Programmers.HighScoreKit.Hash;

//전화번호 목록(Lv2)
/*
phone_book	return
["119", "97674223", "1195524421"]	false
["123","456","789"]	true
["12","123","1235","567","88"]	false
 */
//정렬 후 for문 한 번 만 돌며 바로 앞뒤의 숫자만 비교 해주면 된다.
import java.util.*;

class Ex03_a {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return answer;
    }
}