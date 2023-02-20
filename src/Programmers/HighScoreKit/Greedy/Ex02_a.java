package Programmers.HighScoreKit.Greedy;

//조이스틱(Lv2)
/*
name	return
"JEROEN"	56
"JAN"	23
 */

//상,하와 좌,우 따로 따지기!

class Ex02_a {
    public static void main(String[] args) {
        String name = "JEROEN";
        int answer = 0;
        int move=name.length()-1; //오른쪽으로 쭉 간 횟수
        for(int i=0; i<name.length(); i++) {
            //상,하
            //조이스틱을 위로 조작해 알파벳을 찾는 경우는 'name.charAt(i)' - 'A'
            //처음 'A'에서 아래로 조작해 찾는 경우는 26(총 알파벳 수) - ('name.charAt(i)' - 'A')
            answer+=Math.min(name.charAt(i)-'A',26-(name.charAt(i)-'A')); //상,하 알파벳 맞추기
            //좌,우
            //1. 처음부터 쭉 오른쪽으로 가는 경우
            //    가장 일반적인 경우로 위의 int move = name.length() - 1
            //2. 오른쪽으로 갔다 다시 리턴하여 왼쪽으로 가는 경우
            //    ex) BBAAAAAYYY 의 경우, BB까지 갔다가 다시 돌아가 YYY를 완성해준다.
            //3. 왼쪽으로 갔다 다시 리턴하여 오른쪽으로 가는 경우
            //    ex) CCCAAAAAAY 의 경우, 처음부터 왼쪽으로 움직여 Y를 완성해주고 다시 오른쪽으로 돌아가 CCC를 완성해준다.
            if(i<name.length()-1 && name.charAt(i+1)=='A') {
                int endA=i+1;
                while(endA<name.length() && name.charAt(endA)=='A') {
                    endA++;
                    move = Math.min(move,i*2+(name.length()-endA)); // 오른쪽으로 갔다 다시 왼쪽으로 꺾기
                    move = Math.min(move,i+(name.length()-endA)*2); // 왼쪽으로 갔다 다시 오른쪽으로 꺾기
                }
            }
        }
        System.out.println(answer+move);;
    }
}

//참고:https://born2bedeveloper.tistory.com/26
