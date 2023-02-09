package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//쉬운 계단 수
//자료형 주의!
//자릿수는 오른쪽부터 따지기
public class Ex10844_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long[][] dp=new long[n+1][10]; //자료형 주의!
        int x=1000000000;
        // 첫 번째 자릿수는 오른쪽 맨 끝의 자릿수이므로 경우의 수가 1개밖에 없음
        for(int i=1; i<10; i++) {
            dp[1][i]=1;
        }
        // 두 번째 자릿수부터 N까지 탐색
        for(int i=2; i<=n; i++) {
            // i번째 자릿수의 자릿값들을 탐색 (0~9)
            for(int j=0; j<10; j++) {
                // j=0, 즉 자릿값이 0이라면 이전 자릿수의 첫번째 자릿수만 가능
                if(j==0) {
                    dp[i][0]=dp[i-1][1]%x; //여기도 %x 안해주면 틀림 (길이가 최대 100까지라 정수 long타입의 범위를 넘어감. 답을 1,000,000,000 을 나눈 값을 출력하게 되는데, 만약 매번 모듈러 연산을 하지 않는다면 long타입의 범위 또한 넘길 수 있어 잘못된 값 출력)
                }
                // j=9라면 이전 자릿수는 8만 가능
                else if(j==9) {
                    dp[i][9]=dp[i-1][8]%x; //여기도 %x 안해주면 틀림
                }
                // 그 외의 경우 이전 자릿수의 자릿값 +1, -1 의 합이 됨
                else {
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%x; //여기도 %x 안해주면 틀림
                }
            }
        }
        long answer=0; //자료형 주의!
        for(int i=0; i<10; i++) {
            answer+=dp[n][i];
        }
        System.out.println(answer%x);
    }
}
