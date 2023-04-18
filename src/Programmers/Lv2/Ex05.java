package Programmers.Lv2;

//2021 KAKAO BLIND RECRUITMENT
//메뉴 리뉴얼(Lv2)
/*
orders	course	result
["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	["ACD", "AD", "ADE", "CD", "XYZ"]
["XYZ", "XWY", "WXA"]	[2,3,4]	["WX", "XY"]
 */

//조합
import java.util.*;

class Ex05 {
    static int m;
    static char[] combi;
    static HashMap<String, Integer> map = new HashMap<>();

    static void DFS(int L, int s, String order) {
        if(L==m) {
            String menu = "";
            for(char x : combi) {
                menu+=x;
            }
            map.put(menu,map.getOrDefault(menu,0)+1);
        } else {
            for(int i=s; i<order.length(); i++) {
                combi[L]=order.charAt(i);
                DFS(L+1, i+1, order);
            }
        }
    }

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        String[] answer = {};

        TreeSet<String> set = new TreeSet<>();

        for(int i=0; i<course.length; i++) {
            m = course[i];
            for(int j=0; j<orders.length; j++) {
                combi = new char[m];

                //각 문자열 오름차순 정렬
                String order = orders[j];
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                order = new String(chars);
                DFS(0, 0, order);
            }
        }

        for(int n : course) {
            //최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합
            int max = 2;
            for(String key : map.keySet()) {
                if(key.length() == n && map.get(key)>max) {
                    max=map.get(key);
                }
            }
            for(String key : map.keySet()) {
                //만약 가장 많이 함께 주문된 메뉴 구성이 여러 개라면, 모두 배열에 담음
                if(key.length() == n && map.get(key) == max) {
                    set.add(key);
                }
            }
        }

        answer = set.stream().toArray(String[]::new);

        for(String x : answer) {
            System.out.print(x+" ");
        }
    }
}