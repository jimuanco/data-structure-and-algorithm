package Review.Lecture.HashMap_TreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//아나그램(해쉬)
public class Ex02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1=br.readLine();
        String s2=br.readLine();
        String answer="YES";
        HashMap<Character,Integer> map=new HashMap<>();
        for(char x : s1.toCharArray()) {
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(char x : s2.toCharArray()) {
            if(!map.containsKey(x) || map.get(x)==0) {
                answer="NO";
                break;
            }
            map.put(x,map.get(x)-1);
        }
        System.out.println(answer);
    }
}
