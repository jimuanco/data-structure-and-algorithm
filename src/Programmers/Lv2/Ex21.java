package Programmers.Lv2;

//2018 KAKAO BLIND RECRUITMENT
//[1차] 뉴스 클러스터링(Lv2)

/*
str1	str2	answer
FRANCE	french	16384
handshake	shake hands	65536
aa1+aa2	AAAA12	43690
E=M*C^2	e=m*c^2	65536
 */

import java.util.*;

class Ex21 {
    public static void main(String[] args) {
        String str1 = "FRANCE";
        String str2 = "french";
        int answer = 0;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        String str = "";
        for(int i=0; i<str1.length()-1; i++) {
            if(!Character.isAlphabetic(str1.charAt(i)) || !Character.isAlphabetic(str1.charAt(i+1))) {
                continue;
            }
            str = Character.toUpperCase(str1.charAt(i))+"";
            str +=Character.toUpperCase(str1.charAt(i+1))+"";
            map1.put(str,map1.getOrDefault(str,0)+1);
        }
        for(int i=0; i<str2.length()-1; i++) {
            if(!Character.isAlphabetic(str2.charAt(i)) || !Character.isAlphabetic(str2.charAt(i+1))) {
                continue;
            }
            str = Character.toUpperCase(str2.charAt(i))+"";
            str +=Character.toUpperCase(str2.charAt(i+1))+"";
            map2.put(str,map2.getOrDefault(str,0)+1);
        }

        // for(String x : map1.keySet()) {
        //     System.out.print(x+":"+map1.get(x)+" ");
        // }
        // System.out.println();
        // for(String x : map2.keySet()) {
        //     System.out.print(x+":"+map2.get(x)+" ");
        // }

        int m=0,s=0;

        //교집합 크기 구하기
        if(map1.size()<=map2.size()) {
            for(String x : map1.keySet()) {
                if(map2.containsKey(x)) {
                    s += map1.get(x) >= map2.get(x) ? map2.get(x) : map1.get(x);
                }
            }
        } else {
            for(String x : map2.keySet()) {
                if(map1.containsKey(x)) {
                    s += map1.get(x) >= map2.get(x) ? map2.get(x) : map1.get(x);
                }
            }
        }
        // System.out.println(s);

        //합집합 크기 구하기
        if(map1.size()<=map2.size()) {
            for(String x : map2.keySet()) {
                if(map1.containsKey(x)) {
                    m += map1.get(x) >= map2.get(x) ? map1.get(x) : map2.get(x);
                    map1.remove(x);
                } else {
                    m += map2.get(x);
                }
            }
            for(String x : map1.keySet()) {
                m += map1.get(x);
            }
        } else {
            for(String x : map1.keySet()) {
                if(map2.containsKey(x)) {
                    m += map1.get(x) >= map2.get(x) ? map1.get(x) : map2.get(x);
                    map2.remove(x);
                } else {
                    m += map1.get(x);
                }
            }
            for(String x : map2.keySet()) {
                m += map2.get(x);
            }
        }
        // System.out.println(m);

        if(m!=0) {
            answer = (int)Math.floor((double)(s*65536)/m);
        } else {
            answer = 65536; // 집합 A와 집합 B가 모두 공집합일 경우에는 나눗셈이 정의되지 않으니 따로 J(A, B) = 1로 정의한다.
        }
        System.out.println(answer);
    }
}