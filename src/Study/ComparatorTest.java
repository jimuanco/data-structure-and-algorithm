package Study;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        Integer[] arr = {3,5,10,4,2};
        Arrays.sort(arr,new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a+b.compareTo(a+b);
            }
        });
        for(int x : arr) {
            System.out.print(x+" ");
        }
        String[] str = new String[arr.length];
        for(int i=0; i<arr.length; i++) {
            str[i]=String.valueOf(arr[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        System.out.println();
        for(String s : str) {
            System.out.print(s+" ");
        }
    }
}
