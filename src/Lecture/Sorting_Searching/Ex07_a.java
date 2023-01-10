package Lecture.Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o) {
        if(this.x==o.x) return this.y-o.y;
        else return this.x-o.x;
    }
}

public class Ex07_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Point> arr = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Point(x,y));
        }
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(Point o : arr) {
            sb.append(o.x+" "+o.y+"\n");
        }
        System.out.println(sb);
    }
}
