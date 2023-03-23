package Programmers.HighScoreKit.Hash;

//위장(Lv2)
/*
clothes	return
[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]	5
[["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]	3
 */
import java.util.*;

class Ex04_a {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        // 1. 옷을 종류별로 구분하기
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type,0)+1);
        }

        // 2. 입지 않는 경우를 추가하여 모든 조합 계산하기
        Iterator<Integer> it = map.values().iterator();
        int answer = 1;

        while(it.hasNext()) {
            answer *= it.next().intValue() + 1;
        }

        // 3. 아무종류의 옷도 입지 않는 경우 제외하기
        System.out.println(answer-1);
    }
}

/*
예제1 :
headgear는 총 2개 있으니, 스파이에게는 총 3가지의 경우의 수가 있다.
    1번을 입는다.
    2번을 입는다.
    headgear를 아무것도 입지 않는다.
eyewear는 총 1개 있으니, 스파이에게는 총 2가지의 경우의 수가 있다.
    1번을 입는다.
    eyewear를 입지 않는다.
그렇다면 총 3 x 2 가지의 경우의 수 인 6가지가 존재하고, 이 중 한 가지는 headgear도 입지 않고 eyewear도 입지 않은 경우가 되기 때문에 이 경우를 제외하면 5가지가 정답이 되게 된다.
 */