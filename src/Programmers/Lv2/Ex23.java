package Programmers.Lv2;

//2018 KAKAO BLIND RECRUITMENT
//[1차] 캐시(Lv2)

/*
캐시크기(cacheSize)	도시이름(cities)	실행시간
3	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	50
3	["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]	21
2	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	60
5	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	52
2	["Jeju", "Pangyo", "NewYork", "newyork"]	16
0	["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	25
 */

import java.util.*;

class Ex23 {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        int answer = 0;
        List<String> arr = new ArrayList<>();
        for(int i=0; i<cities.length; i++) {
            String city = cities[i].toUpperCase();
            if(arr.contains(city)) {
                arr.remove(city);
                answer+=1;
            } else {
                answer+=5;
            }
            arr.add(0,city);
            if(arr.size()>cacheSize) {
                arr.remove(arr.size()-1);
            }
        }
        System.out.println(answer);
    }
}
