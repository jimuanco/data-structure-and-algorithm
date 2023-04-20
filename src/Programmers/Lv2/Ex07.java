package Programmers.Lv2;

//2023 KAKAO BLIND RECRUITMENT
//이모티콘 할인행사(Lv2)
/*
users	emoticons	result
[[40, 10000], [25, 10000]]	[7000, 9000]	[1, 5400]
[[40, 2900], [23, 10000], [11, 5200], [5, 5900], [40, 3100], [27, 9200], [32, 6900]]	[1300, 1500, 1600, 4900]	[4, 13860]
 */

/*
완탐.
중복 순열(permutation) 이용.
4개의 원소를 이용해 7개 조합을 만들때도 똑같이 하면 된다.
 */

class Ex07 {
    static int[] rate = {10, 20, 30, 40};
    static int m;
    static int[] pm, answer;
    static int[] sub_emoticons;

    static void DFS(int L, int[][] users, int[] emoticons) {
        //중복 순열로 할인율 경우의 수를 구함
        if(L==m) {
            //할인율에 맞춰 이모티콘 가격을 재정의
            sub_emoticons = emoticons.clone();
            for(int i=0; i<m; i++) {
                sub_emoticons[i] -= (sub_emoticons[i] * pm[i]) / 100;
            }
            int join = 0, total = 0;
            for(int i=0; i<users.length; i++) {
                int sum = 0;
                for(int j=0; j<m; j++) {
                    //각 유저의 기준 비율보다 작은 할인 비율은 구매하지 않는다.
                    if(users[i][0] > pm[j]) continue;
                    sum += sub_emoticons[j];
                    //각 유저의 기준 구매 비용보다 구매 비용의 합이 커진다면 모든 구매를 취소하고 이모티콘 플러스 서비스에 가입한다.
                    if(sum>=users[i][1]) {
                        sum = 0;
                        join++;
                        break;
                    }
                }
                total += sum;
            }
            // System.out.print(join+" ");
            // System.out.println(total);

            //이모티콘 플러스 서비스 가입자가 1순위
            if(answer[0]<join) {
                answer[0]=join;
                answer[1]=total;
                //가입자가 같다면 이모티콘 판매액 늘리기
            } else if(answer[0]==join && answer[1]<total) {
                answer[0]=join;
                answer[1]=total;
            }
        } else {
            for(int i=0; i<4; i++) {
                pm[L]=rate[i];
                DFS(L+1,users,emoticons);
            }
        }
    }

    public static void main(String[] args) {
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};
        answer = new int[2];
        m = emoticons.length;
        pm = new int[m];
        DFS(0,users,emoticons);
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }
}