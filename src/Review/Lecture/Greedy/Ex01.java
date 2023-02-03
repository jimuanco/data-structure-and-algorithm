package Review.Lecture.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Body implements Comparable<Body> {
    public int h,w;
    Body(int h, int w) {
        this.h=h;
        this.w=w;
    }
    @Override
    public int compareTo(Body ob) {
        return ob.h-this.h;
    }
}

//씨름 선수
public class Ex01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<Body> arr = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int h=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            arr.add(new Body(h,w));
        }
        Collections.sort(arr);
        int max=Integer.MIN_VALUE, answer=0;
        for(Body ob : arr) {
            if(ob.w>max) {
                max=ob.w;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
