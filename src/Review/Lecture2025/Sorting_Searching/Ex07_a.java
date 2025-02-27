package Review.Lecture2025.Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 좌표 정렬
/*
5
2 7
1 3
1 2
2 5
3 6
 */
public class Ex07_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Point> arr = new ArrayList<Point>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Point(x, y));
        }
//        Collections.sort(arr);
        arr.sort((p1, p2) -> p1.x != p2.x ? p1.x - p2.x : p1.y - p2.y);
        for (Point p : arr) {
            System.out.println(p.x + " " + p.y);
        }

    }

    private static class Point implements Comparable<Point> {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return this.y - o.y;
            } else {
                return this.x - o.x;
            }
        }
    }
}
