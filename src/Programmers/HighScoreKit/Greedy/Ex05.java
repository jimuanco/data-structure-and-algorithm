package Programmers.HighScoreKit.Greedy;

//섬 연결하기(Lv3)
/*
n	costs	return
4	[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]	4
 */
//Union & Find 문제
import java.util.*;

class Ex05 {
    static int[] unf;
    static int Find(int v) {
        if(v==unf[v]) return v;
        else return unf[v]=Find(unf[v]);
    }

    static void Union(int a, int b) {
        int fa=Find(a);
        int fb=Find(b);
        if(fa!=fb) unf[fa]=fb;
    }

    public static void main(String[] args) {
        int answer = 0;
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        unf = new int[n+1];
        Arrays.sort(costs, (o1, o2) -> o1[2]-o2[2]);
        for(int i=1; i<=n; i++) unf[i]=i;
        int cnt=0;
        for(int[] x : costs) {
            if(cnt==n-1) break;
            int fv1 = Find(x[0]);
            int fv2 = Find(x[1]);
            if(fv1!=fv2) {
                answer+=x[2];
                Union(x[0],x[1]);
                cnt++;
            }
        }
        System.out.println(answer);
    }
}