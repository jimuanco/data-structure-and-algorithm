package Programmers.HighScoreKit.Hash;

//위장(Lv2)
/*
clothes	return
[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]	5
[["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]	3
 */
//n이 30이니 시간초과 나네
import java.util.*;

class Ex04_timeLimitExceeded {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer = 0;
        int n = clothes.length;
        ArrayList<String> arr;
        boolean flag;
        for(int i=1; i<(1<<n); i++) {
            arr = new ArrayList<>();
            flag = true;
            for(int j=0; j<n; j++) {
                if((i & (1<<j)) > 0) {
                    if(arr.contains(clothes[j][1])) {
                        flag=false;
                        break;
                    }
                    arr.add(clothes[j][1]);
                }
            }
            if(flag) {
                answer++;
            }
        }
        System.out.println(answer);;
    }
}