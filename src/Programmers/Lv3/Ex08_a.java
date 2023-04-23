package Programmers.Lv3;

//2021 KAKAO BLIND RECRUITMENT
//합승 택시 요금(Lv3)

/*
n	s	a	b	fares	result
6	4	6	2	[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]	82
7	3	4	1	[[5, 7, 9], [4, 6, 4], [3, 6, 1], [3, 2, 3], [2, 1, 6]]	14
6	4	5	6	[[2,6,6], [6,3,7], [4,6,7], [6,5,11], [2,5,12], [5,3,20], [2,4,8], [4,3,9]]	18
 */

class Ex08_a {
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        int answer = 0;
        int[][] dist = new int[n+1][n+1];
        // String[][] path = new String[n+1][n+1]; //경로 표시
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i==j) {
                    continue;
                }
                //모든 경로를 다 거쳐간 최대값 보다 크게
                dist[i][j] = 200 * 100_000 + 1;
            }
        }

        for(int i=0; i<fares.length; i++) {
            dist[fares[i][0]][fares[i][1]] = fares[i][2];
            dist[fares[i][1]][fares[i][0]] = fares[i][2];
            // path[fares[i][0]][fares[i][1]] = Integer.toString(fares[i][0])+Integer.toString(fares[i][1]);
            // path[fares[i][1]][fares[i][0]] = Integer.toString(fares[i][1])+Integer.toString(fares[i][0]);
        }

        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(dist[i][j] > dist[i][k]+dist[k][j]) {
                        dist[i][j] = dist[i][k]+dist[k][j];
                        // path[i][j] = path[i][k] + path[k][j];
                    }
                }
            }
        }
        // for(int i=1; i<=n; i++) {
        //     for(int j=1; j<=n; j++) {
        //         System.out.print(path[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        answer = dist[s][a] + dist[s][b];

        //경유하는 경우
        for(int i=1; i<=n; i++) {
            answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
        }

        System.out.println(answer);
    }
}