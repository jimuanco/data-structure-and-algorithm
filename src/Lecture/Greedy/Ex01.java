package Lecture.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Body implements Comparable<Body>{
    public int h, w;
    Body(int h, int w) {
        this.h=h;
        this.w=w;
    }
    @Override
    public int compareTo(Body o) {
        return this.h-o.h;
    }
}

//씨름선수 -> 풀이 대로 풀어
public class Ex01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Body> arr = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.add(new Body(h,w));
        }
        Collections.sort(arr);
        int answer=arr.size();
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(arr.get(i).w<arr.get(j).w) {
                    answer--;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
