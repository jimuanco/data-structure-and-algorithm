package Lecture.HashMap_TreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//학급 회장(해쉬)
public class Ex01_a {
    public char solution(int n, String str) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x,0)+1);
        }
//        System.out.println(map.containsKey('F'));
//        System.out.println(map.size());
//        System.out.println(map.remove('C'));
        int max = Integer.MIN_VALUE;
        for(char key : map.keySet()) {
//            System.out.println(key+" "+map.get(key));
            if(max<map.get(key)) {
                max=map.get(key);
                answer=key;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex01_a T = new Ex01_a();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.println(T.solution(n, str));
    }
}
