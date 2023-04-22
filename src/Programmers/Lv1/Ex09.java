package Programmers.Lv1;

//2022 KAKAO BLIND RECRUITMENT
//신고 결과 받기(Lv1)
/*
id_list	report	k	result
["muzi", "frodo", "apeach", "neo"]	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]	2	[2,1,1,0]
["con", "ryan"]	["ryan con", "ryan con", "ryan con", "ryan con"]	3	[0,0]
 */

import java.util.*;

class Ex09 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] answer = {};
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> repo_map = new HashMap<>();
        for(int i=0; i<report.length; i++) {
            String id = report[i].split(" ")[0];
            String reported_id = report[i].split(" ")[1];

            if(map.containsKey(id)) {
                //동일한 유저에 대한 신고 횟수는 1회로 처리
                if(map.get(id).contains(reported_id)) continue;

                map.get(id).add(reported_id);
                repo_map.put(reported_id, repo_map.getOrDefault(reported_id,0)+1);
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(reported_id);
            map.put(id, list);
            repo_map.put(reported_id, repo_map.getOrDefault(reported_id,0)+1);
        }
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<id_list.length; i++) {
            //신고를 한 번도 하지 않은 유저가 있을 수 있음
            if(!map.containsKey(id_list[i])) {
                arr.add(0);
                continue;
            }
            int cnt = 0;
            for(String id : map.get(id_list[i])) {
                //한 유저가 신고한 유저들(한명 이상) 중 k 이상만 count
                if(repo_map.get(id)>=k) {
                    cnt++;
                }
            }
            arr.add(cnt);
        }
        answer = arr.stream().mapToInt(Integer::intValue).toArray();
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }
}

// 자료 구조 이용 단순 구현
// 전형적인 카카오스러운 Lv1 문제
// StringTokenizer가 split보다 빠른데, 이는 spilt의 구조상 정규식을 인자로 받기 때문에 오버헤드가 큼 (하지만 현장(?)에서는 정규식을 쓰는 것이 더욱 안전하고, 권장하는 방법)
// 늘 그렇듯 이 속도 차이로 시간 초과 나게 문제를 내지 않음, split 사용