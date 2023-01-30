package Review.Lecture.HashMap_TreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//모든 아나그램 찾기(Hash, sliding window : 시간복잡도 O(n))
public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a=br.readLine();
        String b=br.readLine();
        int answer=0, lt=0;
        HashMap<Character,Integer> am = new HashMap<>();
        HashMap<Character,Integer> bm = new HashMap<>();
        for(char x : b.toCharArray()) bm.put(x,bm.getOrDefault(x,0)+1);
        int L=b.length()-1;
        for(int i=0; i<L; i++) {
            am.put(a.charAt(i),am.getOrDefault(a.charAt(i),0)+1);
        }
        for(int rt=L; rt<a.length(); rt++) {
            am.put(a.charAt(rt),am.getOrDefault(a.charAt(rt),0)+1);
            if(am.equals(bm)) answer++;
            am.put(a.charAt(lt), am.get(a.charAt(lt))-1);
            if(am.get(a.charAt(lt))==0) am.remove(a.charAt(lt));
            lt++;
        }
        System.out.println(answer);
    }
}
