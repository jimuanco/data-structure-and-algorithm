package Programmers.Lv2;

//2018 KAKAO BLIND RECRUITMENT
//[1차] 프렌즈4블록(Lv2)

/*
m	n	board	answer
4	5	["CCBDE", "AAADE", "AAABF", "CCBBF"]	14
6	6	["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]	15
 */

class Ex22_a {
    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        int answer = 0;
        char[][] table = new char[m][n];
        for(int i=0; i<m; i++) {
            table[i] = board[i].toCharArray();
        }
        while(true) {
            int[][] erased = new int[m][n];
            boolean flag = true;

            //지울 블록 체크
            for(int i=0; i<m-1;i++) {
                for(int j=0; j<n-1; j++) {
                    if(table[i][j]=='-') continue;
                    int f = table[i][j];
                    if(f==table[i][j+1] && f== table[i+1][j] && f ==table[i+1][j+1]) {
                        erased[i][j]=1;
                        erased[i][j+1]=1;
                        erased[i+1][j]=1;
                        erased[i+1][j+1]=1;
                        flag = false;
                    }
                }
            }

            //지울게 없으므로 break
            if(flag) {
                break;
            }

            //블록 지우기
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(erased[i][j]==1) {
                        table[i][j]='-';
                        answer++;
                    }
                }
            }

            //블록 내리기
            for(int i=m-1; i>=0; i--) {
                for(int j=n-1; j>=0; j--) {
                    if(table[i][j]=='-') {
                        for(int k=i-1; k>=0; k--) {
                            if(table[k][j]=='-') {
                                continue;
                            }
                            table[i][j]=table[k][j];
                            table[k][j]='-';
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}