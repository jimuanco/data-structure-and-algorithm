package Programmers.Lv2;

//2022 KAKAO BLIND RECRUITMENT
//k진수에서 소수 개수 구하기(Lv2)

/*
n	k	result
437674	3	3
110011	10	2
 */

class Ex14 {
    public static void main(String[] args) {
        int n = 437674;
        int k = 3;
        int answer = 0;
        String num = Integer.toString(n,k);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num.length(); i++) {
            if(num.charAt(i) != '0') {
                sb.append(num.charAt(i));
            } else {
                if(sb.toString().length() == 0) continue;
                if(isPrime(Long.parseLong(sb.toString()))) {
                    answer++;
                }
                sb = new StringBuilder();
            }
        }

        // P 처럼 소수 양쪽에 아무도 없는 경우
//        System.out.println(sb);
        if(sb.toString().length() != 0) {
            if(isPrime(Long.parseLong(sb.toString()))) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static boolean isPrime(Long num) {
        if(num==1) return false;
        for(int i=2; i<=(int)Math.sqrt(num); i++) {
            if(num%i==0) return false;
        }
        return true;
    }
}