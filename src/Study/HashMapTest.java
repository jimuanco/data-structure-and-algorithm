package Study;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        String answer = "";
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('R',1);
        map.put('T',1);
        answer += map.get('R') >= map.get('C') ? 'R' : 'T';
        System.out.println(answer);

    }
}
