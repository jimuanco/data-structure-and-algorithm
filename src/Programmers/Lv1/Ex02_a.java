package Programmers.Lv1;

//기사단원의 무기(Lv1)
/*
number	limit	power	result
5	3	2	10
10	3	2	21
 */
class Ex02_a {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1; i<=number; i++) {

            //약수 구하기
            int cnt = 0;
            for(int j=1; j*j<=i; j++) {
                if(j * j == i) cnt++;
                else if(i % j == 0) cnt+=2;
            }

            answer += cnt > limit ? power : cnt ;
        }
        return answer;
    }
}