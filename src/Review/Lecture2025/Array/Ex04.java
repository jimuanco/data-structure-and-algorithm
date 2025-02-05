package Review.Lecture2025.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 피보나치 수열
// 10
public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        for (int i = 2; i < n; i++) {
            arr.add(arr.get(i - 1) + arr.get(i - 2));
        }
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
