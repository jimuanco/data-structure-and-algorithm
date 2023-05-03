package Programmers.Lv2;

//연습문제
//숫자 변환하기

/*
x	y	n	result
10	40	5	2
10	40	30	1
2	5	4	-1
 */

//TC 5,7,11,14 시간초과
//TC 9,10 런타임 에러

//재귀로 풀면 안됨

class Ex20_wrong {
    static int answer = Integer.MAX_VALUE;
    public int solution(int x, int y, int n) {
        DFS(x,y,n,0);
        if(x==y) return 0;
        if(answer==Integer.MAX_VALUE) {
            answer = -1;
        }
        return answer;
    }
    static void DFS(int x, int y, int n, int L) {
        if(x>y) return;
        if(L>answer) return;
        if(x==y) {
            answer = L;
        } else {
            for(int i=0; i<3; i++) {
                if(i==0) {
                    DFS(x*2,y,n,L+1);
                } else if(i==1) {
                    DFS(x*3,y,n,L+1);
                } else {
                    DFS(x+n,y,n,L+1);
                }
            }
        }
    }
}