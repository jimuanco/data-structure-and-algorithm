package Study;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysEquals {
    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5};
        int[] arr2={1,2,3,4,6};

        System.out.println(Arrays.equals(arr1,arr2)); //false

        int[][] arr3={{1,2,3},{1,2,3}};
        int[][] arr4={{1,2,3},{1,2,3}};
        System.out.println(Arrays.equals(arr3,arr4)); //false
        System.out.println(Arrays.deepEquals(arr3,arr4)); //true

        ArrayList<Integer> arr5= new ArrayList<>();
        for(int i=1; i<=3; i++) {
            arr5.add(i);
        }
        System.out.println(arr5.stream().mapToInt(e->e).sum()); //6
        System.out.println(Arrays.stream(arr1).sum()); //여기서 1차원 배열만 가능
        System.out.println(Arrays.stream(arr1).max().getAsInt()); //여기서 1차원 배열만 가능
        System.out.println(Arrays.stream(arr1).min().getAsInt()); //여기서 1차원 배열만 가능
    }
}
