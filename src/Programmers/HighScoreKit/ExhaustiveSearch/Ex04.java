package Programmers.HighScoreKit.ExhaustiveSearch;

//카펫(Lv2)
/*
brown	yellow	return
10	2	[4, 3]
8	1	[3, 3]
24	24	[8, 6]
 */
class Solution {
    public static void main(String[] args) {
        int brown=10;
        int yellow=2;
        int[] answer = {};
        answer=new int[2];
        int num=(brown-4)/2;
        for(int i=num; i>0; i--) {
            for(int j=num-i; j<=i; j++) {
                if(i*j==yellow) {
                    answer[0]=i+2;
                    answer[1]=j+2;
                }
            }
        }
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }
}
