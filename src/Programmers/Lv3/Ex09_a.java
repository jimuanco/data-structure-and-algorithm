package Programmers.Lv3;


//2021 Dev-Matching: 웹 백엔드 개발자(상반기)
//다단계 칫솔 판매(Lv3)

/*
enroll	referral	seller	amount	result
["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]	["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]	["young", "john", "tod", "emily", "mary"]	[12, 4, 2, 5, 10]	[360, 958, 108, 0, 450, 18, 180, 1080]
["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]	["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]	["sam", "emily", "jaimie", "edward"]	[2, 3, 5, 4]	[0, 110, 378, 180, 270, 450, 0, 0]
 */

//DFS 문제(부모노드 호출)
import java.util.*;

class Ex09_a {

    static Map<String, String> parentMap = new HashMap<>();
    static Map<String, Integer> revenue = new HashMap<>();
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        int[] answer = {};
        for(int i=0; i< enroll.length; i++) {
            if(referral[i].equals("-")) continue;
            parentMap.put(enroll[i], referral[i]);
        }
        for(int i=0; i<seller.length; i++) {
            DFS(seller[i], amount[i] * 100);
        }
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<enroll.length; i++) {
            if(revenue.containsKey(enroll[i])) {
                arr.add(revenue.get(enroll[i]));
            } else {
                arr.add(0);
            }
        }
        answer = arr.stream().mapToInt(Integer::intValue).toArray();
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }

    static void DFS(String person, int total) {
        revenue.put(person, revenue.getOrDefault(person,0)+total-(int)(total * 0.1));
        //total * 0.1이 1보다 작을때는 분배금이 없다.
        //그럼에도 DFS를 호출하면 TC 11~13 시간 초과
        if(parentMap.containsKey(person) && total * 0.1 >= 1) {
            DFS(parentMap.get(person), (int)(total * 0.1));
        }
    }
}
