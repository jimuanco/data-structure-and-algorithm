package Lecture.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//씨름선수 -> o(n)
class Body2 implements Comparable<Body2> {
    public int h, w;
    Body2(int h, int w) {
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Body2 o) {
        return o.h-this.h;
    }
}

public class Ex01_a {
    public int solution(ArrayList<Body2> arr, int n) {
        int answer=0;
        Collections.sort(arr);
        int max=Integer.MIN_VALUE;
        for(Body2 ob : arr) {
            if(ob.w>max) {
                max=ob.w;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex01_a T = new Ex01_a();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Body2> arr = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.add(new Body2(h,w));
        }
        System.out.println(T.solution(arr,n));
    }
}
