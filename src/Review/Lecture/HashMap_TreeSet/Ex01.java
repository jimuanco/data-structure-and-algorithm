package Review.Lecture.HashMap_TreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//학급 회장(해쉬)
public class Ex01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String str=br.readLine();
        char answer =' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : str.toCharArray()) {
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int max=Integer.MIN_VALUE;
        for(char key : map.keySet()) {
            if(max<map.get(key)) {
                max=map.get(key);
                answer=key;
            }
        }
        System.out.println(answer);
    }
}
