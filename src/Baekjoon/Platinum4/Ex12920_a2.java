package Baekjoon.Platinum4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//평범한 배낭2
//단순히 삼중포문으로 풀면 O(N*K*M) 즉, 100*10000*10000으로 시간초과
//따라서 물건을 2의 제곱수의 합으로 분할하는 기법을 사용하여 물건의 수를 줄여줘야 함 -> O(N*log(K)*M)
//a1풀이 보다 이게 좀 더 효율좋음(69568KB	244ms)
class Stuff {
    int weight, satisfaction;
    Stuff(int weight, int satisfaction) {
        this.weight=weight;
        this.satisfaction=satisfaction;
    }
}

public class Ex12920_a2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<Stuff> stuff = new ArrayList<>();
        stuff.add(new Stuff(0,0)); //index 1부터 따지기 위해
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight= Integer.parseInt(st.nextToken());
            int satisFaction= Integer.parseInt(st.nextToken());
            int count=Integer.parseInt(st.nextToken());
            int tmpC=1;
            while(tmpC<=count) {
                stuff.add(new Stuff(weight*tmpC,satisFaction*tmpC));
                count-=tmpC;
                tmpC*=2;
            }
            if(count!=0) {
                stuff.add(new Stuff(weight*count,satisFaction*count));
            }
        }
        int curN=stuff.size();
        int[][] dp=new int[curN+1][m+1];
        for(int i=1; i<=curN-1; i++) {
            for(int j=1; j<=m; j++) {
                if(j>=stuff.get(i).weight) {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-stuff.get(i).weight]+stuff.get(i).satisfaction);
                } else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[curN-1][m]);
    }
}

/*
3 9
8 5 1
1 4 2
9 4 1
 */