package Baekjoon.Platinum4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//평범한 배낭2
//단순히 삼중포문으로 풀면 O(N*K*M) 즉, 100*10000*10000으로 시간초과
//따라서 물건을 2의 제곱수의 합으로 분할하는 기법을 사용하여 물건의 수를 줄여줘야 함 -> O(N*log(K)*M)
//a2보다 조금 효율 떨어짐(69676KB	264ms)
//밑에 설명
public class Ex12920_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<int[]> stuff = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight= Integer.parseInt(st.nextToken());
            int satisFaction= Integer.parseInt(st.nextToken());
            int count=Integer.parseInt(st.nextToken());
            for(int j=0; count>0; j++) {
                int tmp=Math.min(1<<j, count); //1<<j -> Shift연산
                int curWeight=weight*tmp;
                int curSatisFaction=satisFaction*tmp;
                stuff.add(new int[] {curWeight,curSatisFaction});
                count -=tmp;
            }
        }
        int curN=stuff.size();
        int[][] dp=new int[curN+1][m+1];
        for(int i=1; i<=curN; i++) {
            for(int j=1; j<=m; j++) {
                if(j>=stuff.get(i-1)[0]) {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-stuff.get(i-1)[0]]+stuff.get(i-1)[1]);
                } else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[curN][m]);
    }
}

/*
j를 0부터 시작해서(2^0부터 시작) count(물건의 개수)가 0이될때까지 반복한다.

int tmp = Math.min(1<<j, count) 부분이 필요한 이유는 모든 수가 15(1,2,4,8) 처럼 딱 떨어지면 괜찮은데

물건의 개수인 K를 무조건적으로 2의 제곱수의 합으로만 바꿔주면 만약 int tmp = (1<<j) 13이면 (1,2,4,8)이 되는데

이렇게 되면 모든 수의 합이 13보다 큰 15까지 될 수 있기 때문에

만약 count가 1<<j보다 작으면 count(남은 수)를 넣어주면 (1,2,4,6)이 되서

1, 2, 3(1+2), 4, 5(1+4), 6, 7(1+6), 8(2+6), 9(1+2+6), 10(4+6), 11(1+4+6), 12(2+4+6), 13(1+2+4+6)이 되어서

모든 경우의 수를 더해도 13까지 나오기 때문에 Math.min(1<<j, count) 이 부분이 필요하다.

출처:https://thsd-stjd.tistory.com/83
 */

/*
3 9
8 5 1
1 4 2
9 4 1
 */