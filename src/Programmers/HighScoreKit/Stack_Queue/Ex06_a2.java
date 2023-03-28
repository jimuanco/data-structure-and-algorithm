package Programmers.HighScoreKit.Stack_Queue;

//주식가격(Lv2)
/*
prices	return
[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
 */
class Ex06_a2 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length; i++) {
            for(int j=i+1; j<prices.length; j++) {
                answer[i]++;
                if(prices[i]>prices[j]) break;
            }
        }
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }
}