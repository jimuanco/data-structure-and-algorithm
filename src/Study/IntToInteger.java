package Study;

import java.util.Arrays;
import java.util.Collections;

public class IntToInteger {
    public static void main(String[] args) {
        int[] arr = {1,5,3,4};
//        Arrays.sort(arr, Collections.reverseOrder()); -> 안됨
        Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr2, Collections.reverseOrder());
        Arrays.sort(arr2, (o1,o2) -> o2-o1);
        for(int x : arr2) {
            System.out.println(x);
        }
    }
}
