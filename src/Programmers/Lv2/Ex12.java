package Programmers.Lv2;

//2022 KAKAO BLIND RECRUITMENT
//주차 요금 계산(Lv2)

/*
fees	records	result
[180, 5000, 10, 600]	["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]	[14600, 34400, 5000]
[120, 0, 60, 591]	["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]	[0, 591]
[1, 461, 1, 10]	["00:00 1234 IN"]	[14841]
 */

import java.util.*;

class Ex12 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] answer;
        Map<String, Integer> car_map = new HashMap<>();
        Map<String, Integer> time_map = new HashMap<>();
        int tot_time;
        for(int i=0; i<records.length; i++) {
            int time = Integer.parseInt(records[i].split(" ")[0].split(":")[0]) * 60;
            time += Integer.parseInt(records[i].split(" ")[0].split(":")[1]);
            String car_num = records[i].split(" ")[1];
//            String action = records[i].split(" ")[2];
            if(!car_map.containsKey(car_num)) {
                car_map.put(car_num, time);
            } else {
                tot_time = (time - car_map.get(car_num));
                time_map.put(car_num, time_map.getOrDefault(car_num,0)+tot_time);
                car_map.remove(car_num);
            }
        }

        //23:59분에 출차된 차량 따져준다.
        for(String key : car_map.keySet()) {
            tot_time = 1439 - car_map.get(key);
            time_map.put(key, time_map.getOrDefault(key,0)+tot_time);
        }

        answer = new int[time_map.size()];

        //key로 오름차순 하기 위해 TreeMap
        Map<String, Integer> sorted_map = new TreeMap<>(time_map);

        int idx = 0;
        for(String key : sorted_map.keySet()) {
            tot_time = sorted_map.get(key);

            //기본 요금일 경우
            if(tot_time <= fees[0]) {
                answer[idx] = fees[1];
            } else {
                //이렇게 해야 제대로 올림
                int add_fee =(int)Math.ceil((double)(tot_time - fees[0]) / fees[2]) * fees[3] ;
                answer[idx] = fees[1] + add_fee;
            }
            idx++;
        }

        for(int x : answer) {
            System.out.print(x+" ");
        }
    }
}
