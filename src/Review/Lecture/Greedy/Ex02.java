package Review.Lecture.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Time implements Comparable<Time> {
    public int s,e;
    Time(int s, int e) {
        this.s=s;
        this.e=e;
    }
    @Override
    public int compareTo(Time ob) {
        if(this.e==ob.e) return this.s-ob.s;
        else return this.e-ob.e;
    }
}

//회의실 배정
public class Ex02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<Time> arr = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            arr.add(new Time(s,e));
        }
        Collections.sort(arr);
        int et=Integer.MIN_VALUE, answer=0;
        for(Time ob : arr) {
            if(ob.s>=et) {
                answer++;
                et=ob.e;
            }
        }
        System.out.println(answer);
    }
}
