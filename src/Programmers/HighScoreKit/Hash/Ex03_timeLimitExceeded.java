package Programmers.HighScoreKit.Hash;

//전화번호 목록(Lv2)
/*
phone_book	return
["119", "97674223", "1195524421"]	false
["123","456","789"]	true
["12","123","1235","567","88"]	false
 */
//효율성 테스트 3,4 실패
class Ex03_timeLimitExceeded {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for(int i=0; i<phone_book.length; i++) {
            for(int j=i+1; j<phone_book.length; j++) {
                if(phone_book[i].startsWith(phone_book[j])) {
                    return false;
                }
                if(phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
            }
        }
        return answer;
    }
}