package Programmers.Lv2;

//Summer/Winter Coding(2019)
//멀쩡한 사각형(Lv2)

/*
W	H	result
8	12	80
 */

//유클리드 호제법
//최대공약수 구하기

class Ex31_a {
    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        long answer = 1;
        int gcd = getGcd(h,w);
        answer = ((long)w * (long)h - (((w/gcd) + (h/gcd)) - 1) * gcd);
        System.out.println(answer);
    }
    static int getGcd(int a, int b) {
        if(a % b == 0) {
            return b;
        } else {
            return getGcd(b,a%b);
        }
    }
}
