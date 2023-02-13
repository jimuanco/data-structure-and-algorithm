package Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//잃어버린 괄호

//최솟값을 만들기 위해선 최대한 '큰 수'를 빼주어야 함.
//즉, 덧셈(+)으로 이루어진 부분을 먼저 계산한 뒤 빼줘야 함.
//예) 30-70-20+40-10+100+30-35 -> 30-70-(20+40)-(10+100+30)-35
//문자열을 분리해주는 split()함수나 StringTokenizer클래스를 사용
//문제 조건에서 첫번째 수는 양수!
public class Ex1541_a1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 초기 상태 여부 확인을 위한 값으로 설정
        int sum=Integer.MAX_VALUE;
        StringTokenizer subtraction = new StringTokenizer(br.readLine(),"-");
        while(subtraction.hasMoreTokens()) {
            int temp=0;
            // 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
            StringTokenizer addition = new StringTokenizer(subtraction.nextToken(),"+");
            // 덧셈으로 나뉜 토큰들을 모두 더한다.
            while(addition.hasMoreTokens()) {
                temp+=Integer.parseInt(addition.nextToken());
            }
            // 첫 번째토큰인 경우 temp값이 첫 번째 수가 됨
            if(sum==Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
