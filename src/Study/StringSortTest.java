package Study;

import java.util.Arrays;

public class StringSortTest {
    public static void main(String[] args) {
        String[] arr = {"12", "20", "123", "120", "124", "12345"};
        Arrays.sort(arr);
        for(String x : arr) {
            System.out.print(x+" "); //12 120 123 12345 124 20
        }

        System.out.println();
        System.out.println(arr[2].substring(0,0));
        System.out.println(arr[2].substring(0,1));
        System.out.println(arr[2].substring(0,2));
        System.out.println(arr[2].substring(0,3));
        System.out.println(arr[2].substring(0,arr[2].length()-1));
    }
}
