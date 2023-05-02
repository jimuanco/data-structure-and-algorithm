package Programmers.Lv2;

//2020 KAKAO BLIND RECRUITMENT
//문자열 압축(Lv2)

/*
s	result
"aabbaccc"	7
"ababcdcdababcdcd"	9
"abcabcdede"	8
"abcabcabcabcdededededede"	14
"xababcdcdababcdcd"	17
 */

class Ex13_a {
    public static void main(String[] args) {
        String s = "aabbaccc";
        int answer = s.length();
        int cnt = 1;

        // 절반을 넘게 되면 두 번 이상 반복 될 수 없음
        for(int i=1; i<=s.length()/2; i++) {
            StringBuilder result = new StringBuilder();
            String base = s.substring(0,i);

            // 이미 base에서 하나는 count 함 (j=i)
            for(int j=i; j<=s.length(); j+=i) {

                // 인덱스는 길이를 넘을 수 없음
                int end_idx = Math.min(j+i, s.length());
                String another = s.substring(j, end_idx);
                if(base.equals(another)) {
                    cnt++;
                } else {
                    if(cnt >= 2) {
                        result.append(cnt);
                    }
                    result.append(base);

                    //마지막 인덱스일때 한번 더 더해야함 (딱 안떨어지는 경우 있음)
                    base = another;
                    cnt = 1;
                }
            }

            //마지막 문자 붙이기
            result.append(base);
            answer = Math.min(answer, result.length());
        }
        System.out.println(answer);
    }
}