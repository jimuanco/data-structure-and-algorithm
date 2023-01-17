package Lecture.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//회의실 배정(o(n)) -> 끝나는 순으로 오름차순 (같다면 시작순으로 오름차순)
class Time implements Comparable<Time> {
    public int s, e;
    Time(int s, int e) {
        this.s=s;
        this.e=e;
    }
    @Override
    public int compareTo(Time o) {
        if(this.e==o.e) return this.s-o.s;
        else return this.e-o.e;
    }
}

public class Ex02_a {
    public int solution(ArrayList<Time> arr, int n) {
        int answer=0;
        Collections.sort(arr);
        int et=Integer.MIN_VALUE;
        for(Time ob : arr) {
            if(ob.s>=et) {
                answer++;
                et=ob.e;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex02_a T = new Ex02_a();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Time> arr = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.add(new Time(s,e));
        }
        System.out.println(T.solution(arr, n));
    }
}
