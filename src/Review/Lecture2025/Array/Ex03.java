package Review.Lecture2025.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 가위 바위 보
/*
5
2 3 3 1 3
1 1 2 2 3
 */
public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];
        int[] arrB = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        List<Character> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arrA[i] == 1 && arrB[i] == 3) {
                answer.add('A');
            } else if (arrA[i] == 2 && arrB[i] == 1) {
                answer.add('A');
            } else if (arrA[i]  == 3 && arrB[i] == 2) {
                answer.add('A');
            } else if (arrA[i] == arrB[i]) {
                answer.add('D');
            } else {
                answer.add('B');
            }
        }

        for (Character c : answer) {
            System.out.println(c);
        }

    }
}
