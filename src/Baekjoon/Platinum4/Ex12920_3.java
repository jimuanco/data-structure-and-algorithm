package Baekjoon.Platinum4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//평범한 배낭2
//단순히 삼중포문으로 풀면 O(N*K*M) 즉, 100*10000*10000으로 시간초과
//따라서 물건을 2의 제곱수의 합으로 분할하는 기법을 사용하여 물건의 수를 줄여줘야 함 -> O(N*log(K)*M)
//굳이 다중 배열 쓸 필요 없음, 유한냅색은 끝에서 부터 ! -> a2보다도 더 효율 좋음(14660KB	180ms)
class Stuff2 {
    int weight, satisfaction;
    Stuff2(int weight, int satisfaction) {
        this.weight=weight;
        this.satisfaction=satisfaction;
    }
}

public class Ex12920_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<Stuff2> stuff = new ArrayList<>();
        stuff.add(new Stuff2(0,0)); //index 1부터 따지기 위해
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight= Integer.parseInt(st.nextToken());
            int satisFaction= Integer.parseInt(st.nextToken());
            int count=Integer.parseInt(st.nextToken());
            int tmpC=1;
            while(tmpC<=count) {
                stuff.add(new Stuff2(weight*tmpC,satisFaction*tmpC));
                count-=tmpC;
                tmpC*=2;
            }
            if(count!=0) {
                stuff.add(new Stuff2(weight*count,satisFaction*count));
            }
        }
        int curN=stuff.size();
        int[]dp=new int[m+1];
        for(int i=1; i<=curN-1; i++) {
            for(int j=m; j>=stuff.get(i).weight; j--) {
                dp[j]=Math.max(dp[j],dp[j-stuff.get(i).weight]+stuff.get(i).satisfaction);
            }
        }
        System.out.println(dp[m]);
    }
}

/*
3 9
8 5 1
1 4 2
9 4 1
 */