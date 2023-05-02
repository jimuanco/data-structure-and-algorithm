package Programmers.Lv2;

//2022 KAKAO BLIND RECRUITMENT
//양궁대회(Lv2)

/*
n	info	result
5	[2,1,1,1,0,0,0,0,0,0,0]	[0,2,2,0,1,0,0,0,0,0,0]
1	[1,0,0,0,0,0,0,0,0,0,0]	[-1]
9	[0,0,1,2,0,1,1,1,1,1,1]	[1,1,2,0,1,2,2,0,0,0,0]
10	[0,0,0,0,0,0,0,0,3,4,3]	[1,1,1,1,1,1,1,1,0,0,2]
 */

//중복 조합!
class Ex15 {

    static int[] score = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static int[] combi;
    static int[] ryan_score;
    static int[] answer = new int[11];
    static int difference = 0;

    public static void main(String[] args) {
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        combi = new int[n];
        DFS(0,0,n,info);
//        if(difference == 0) return new int[]{-1}; // 배열 리턴
        if(difference == 0) System.out.println(-1);
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }

    static void DFS(int L, int s, int n, int[] info) {
        if(L == n) {
            ryan_score = new int[11];
            for(int x : combi) {
                ryan_score[10-x]++;
            }
            int apeach_sum=0, ryan_sum=0;
            for(int i=0; i<11; i++) {
                if(info[i] == 0 && ryan_score[i] == 0) continue;
                if(info[i]<ryan_score[i]) {
                    ryan_sum+=10-i;
                } else {
                    apeach_sum+=10-i;
                }
            }

            // 점수차가 더 큰 걸로 answer를 갱신
            if(difference < ryan_sum-apeach_sum) {
                difference = ryan_sum-apeach_sum;
                answer = ryan_score.clone();
            }
            // "라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우,
            // 가장 낮은 점수를 더 많이 맞힌 경우를 return 해주세요."
            // "[0,0,2,3,4,1,0,0,0,0,0]과 [9,0,0,0,0,0,0,0,1,0,0]를 비교하면[9,0,0,0,0,0,0,0,1,0,0]를 return 해야 합니다."
            else if(difference == ryan_sum-apeach_sum) {
                int ryan_min=-1, answer_min=-1;
                for(int i=10; i>=0; i--) {
                    if(answer[i] < ryan_score[i]) {
                        ryan_min = Math.max(ryan_min, i);
                    } else if(answer[i] > ryan_score[i]) {
                        answer_min = Math.max(answer_min, i);
                    }
                }
                // 똑같은 차이일 때 가장 낮은 점수를 더 많이 맞힌 경우로 answer를 갱신한다.
                if(answer_min < ryan_min) answer = ryan_score.clone();
            }
        } else {
            for(int i=s; i<11; i++) {
                combi[L]=score[i];
                DFS(L+1, i, n, info);
            }
        }
    }
}