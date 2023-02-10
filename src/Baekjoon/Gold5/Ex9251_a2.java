package Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//LCS
//LCS의 대표적인 문제임
//Top-Down(재귀) ->Bottom-Up 보다 성능 안좋음(아무래도 오버헤드 비용이 재귀가 높다보니 그럴 것 같다. 메모이제이션을 했지만, for문으로 시간복잡도 O(N), 재귀 시간 복잡도 O(N) 으로 같아보일 순 있으나 메모리에 로드하는 비용이 for문보다 재귀가 훨씬 비싸기 때문이라고 보고 있다.)
public class Ex9251_a2 {
    static char[] str1;
    static char[] str2;
    static Integer[][] dp;
    static int LCS(int x, int y) {
        // 인덱스 밖 (공집합)일 경우 0 반환
        if(x==-1 || y==-1) {
            return 0;
        }
        // 만약 탐색하지 않은 인덱스라면?
        if(dp[x][y]==null) {
            dp[x][y]=0; //이 문제에서는 이거 없어도 됨

            // str1의 x번째 문자와 str2의 y번째 문자가 같은지 검사
            if(str1[x]==str2[y]) {
                dp[x][y]=LCS(x-1,y-1)+1;
            }

            // 같지 않다면 LCS(dp)[x-1][y]와 LCS(dp)[x,y-1] 중 큰 값으로 초기화
            else {
                dp[x][y]=Math.max(LCS(x-1,y),LCS(x,y-1));
            }
        }
        return dp[x][y];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1=br.readLine().toCharArray();
        str2=br.readLine().toCharArray();
        dp=new Integer[str1.length][str2.length];
        System.out.println(LCS(str1.length-1,str2.length-1));
    }
}
