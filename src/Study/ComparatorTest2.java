package Study;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest2 {
    public static void main(String[] args) {
        int[][] arr = {{0,3},{2,6},{1,9}};
//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
//        for(int[] x: arr) {
//            for(int y : x) {
//                System.out.print(y+" ");
//            }
//            System.out.println();
//        }

//        Arrays.sort(arr); //오류 남
//        Arrays.sort(arr, (o1,o2) -> o1[0]-o2[0]);
        Arrays.sort(arr, (o1,o2) -> o2[0]-o1[0]);
        for(int[] x: arr) {
            for(int y : x) {
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }
}
