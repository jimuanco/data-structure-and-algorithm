package Review.Lecture2025.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 씨름선수 -> o(n)
/*
5
172 67
183 65
180 70
170 72
181 60
 */
public class Ex01_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Body> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Body(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        list.sort(((o1, o2) -> Integer.compare(o2.h, o1.h)));
        int max =  Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (list.get(i).w > max) {
                cnt++;
                max = list.get(i).w;
            }
        }
        System.out.println(cnt);
    }

    private static class Body {
        int h, w;
        Body (int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
}
