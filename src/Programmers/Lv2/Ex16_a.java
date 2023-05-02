package Programmers.Lv2;

//2021 KAKAO BLIND RECRUITMENT
//순위 검색(Lv2)

/*
info	query	result
["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150"
,"cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"]
["java and backend and junior and pizza 100","python and frontend and senior and chicken 200"
,"cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100"
,"- and - and - and - 150"]	[1,1,1,1,2,4]
 */

import java.util.*;

class Ex16_a {
    static Map<String, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210"
                ,"python frontend senior chicken 150","cpp backend senior pizza 260"
                ,"java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200"
                ,"cpp and - and senior and pizza 250","- and backend and senior and - 150"
                ,"- and - and - and chicken 100","- and - and - and - 150"};
        int[] answer = new int[query.length];

        for(int i=0; i<info.length; i++) {
            String[] p = info[i].split(" ");
            makeSentence(p, "", 0);
        }

        //map의 value인 점수 List들을 오름차순으로 정렬
        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for(int i=0; i<query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }

        for(int x : answer) {
            System.out.print(x+" ");
        }
    }

    static int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0, end = list.size() - 1;

        //lowerBond -> target보다 첫번째로 작은 원소의 인덱스 리턴
        while(start <= end) {
            int mid = (start + end) / 2;
            if(list.get(mid) >= score) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        //target과 같거나 target 보다 큰 점수의 갯수
        return list.size() - 1 - end;
    }

    static void makeSentence(String[] p, String str, int cnt) {
        if(cnt == 4) {
            if(!map.containsKey(str)) {
                List<Integer> list = new ArrayList<>();
                map.put(str, list);
            }
            map.get(str).add(Integer.parseInt(p[4]));
            return;
        }
        makeSentence(p, str + "-", cnt+1);
        makeSentence(p, str + p[cnt], cnt+1);
    }
}