package Programmers.Lv1;

//기사단원의 무기(Lv1)
/*
number	limit	power	result
5	3	2	10
10	3	2	21
 */
//시간 초과
class Ex02 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1; i<=number; i++) {
            int cnt = 0;
            for(int j=1; j<=i; j++) {
                if(i % j == 0) cnt++;
            }
            answer += cnt > limit ? power : cnt ;
        }
        return answer;
    }
}