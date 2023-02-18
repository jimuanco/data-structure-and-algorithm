package Study;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        List<Set<Integer>> setList = new ArrayList<>();
        for(int i=0; i<9; i++) {
            setList.add(new HashSet<>());
        }
        for(int i=0; i<9; i++) {
            setList.get(i).add(i);
            setList.get(i).add(i*10);
        }
        for(int i=0; i<9; i++) {
            for(int x : setList.get(i)) {
//                System.out.println(x);
            }
        }
        Set<Integer>[] set = new HashSet[9];
        int cnt=0;
        for(int i=1; i<9; i++) {
            cnt=(cnt*10)+5;
            set[i]=new HashSet<>();
            set[i].add(cnt);
        }
        for(int i=1; i<9; i++) {
            for(int x : set[i]) {
//                System.out.println(x);
            }
        }

//        ArrayList<Integer>[] arr = new ArrayList[9];
        ArrayList<Integer> arr[] = new ArrayList[9];
        cnt=0;
        for(int i=1; i<9; i++) {
            cnt=(cnt*10)+5;
            arr[i]=new ArrayList<>();
            arr[i].add(cnt);
        }
        for(int i=1; i<9; i++) {
            for(int x : arr[i]) {
                System.out.println(x);
            }
        }
    }
}
