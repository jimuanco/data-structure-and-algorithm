package Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//잃어버린 괄호

//최솟값을 만들기 위해선 최대한 '큰 수'를 빼주어야 함.
//즉, 덧셈(+)으로 이루어진 부분을 먼저 계산한 뒤 빼줘야 함.
//예) 30-70-20+40-10+100+30-35 -> 30-70-(20+40)-(10+100+30)-35
//문자열을 분리해주는 split()함수나 StringTokenizer클래스를 사용
//문제 조건에서 첫번째 수는 양수!
public class Ex1541_a2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 초기 상태 여부 확인을 위한 값으로 설정
        int sum=Integer.MAX_VALUE;
        String[] subtraction = br.readLine().split("-");

        for(int i=0; i<subtraction.length; i++) {
            int temp=0;

            //split의 경우 정규식(regex)을 받기 때문에 "+"을 하면 regex.PatternSyntaxException을 뱉음.
            //+ 문자가 메타문자(meta character=특별한 의미를 담고 있다는 뜻)
            //그렇기 때문에 온전하게 문자 그 자체로 이용하기 위해서는 이스케이프 처리를 해야함.
            //하지만 \(백슬래시)도 단독으로 출력할 수 없기 때문에 백슬래시 자체도 이스케이프 해야함.
            //즉 \\+ 를 해야 우리가 분리하고자 하는 "+" 문자 그대로 분리할 수 있다.

            // 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
            String[] addition = subtraction[i].split("\\+");

            // 덧셈으로 나뉜 토큰들을 모두 더한다.
            for(int j=0; j<addition.length; j++) {
                temp += Integer.parseInt(addition[j]);
            }

            // 첫 번째토큰인 경우 temp값이 첫 번째 수가 됨
            if(sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}

// StringTokenizer가 split보다 빠른데, 이는 spilt의 구조상 정규식을 인자로 받기 때문에 오버헤드가 큼 (하지만 현장(?)에서는 정규식을 쓰는 것이 더욱 안전하고, 권장하는 방법)