package Programmers.Lv2;

//2018 KAKAO BLIND RECRUITMENT
//[3차] n진수 게임(Lv2)

/*
n	t	m	p	result
2	4	2	1	"0111"
16	16	2	1	"02468ACE11111111"
16	16	2	2	"13579BDF01234567"
 */
class Ex27 {
    public static void main(String[] args) {
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 2;
        String answer = "";
        String total = "";
        for(int i=0; i<t*m-(m-p); i++) {
            total += Integer.toString(i,n).toUpperCase();
            if(total.length() >= t*m) {
                break;
            }
        }
        for(int i=p-1; i<t*m; i+=m) {
            answer += total.charAt(i);
        }
        System.out.println(answer);
    }
}
