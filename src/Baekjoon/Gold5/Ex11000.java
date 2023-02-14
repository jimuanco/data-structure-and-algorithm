package Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Time implements Comparable<Time> {
    public int time;
    char state;
    Time(int time, char state) {
        this.time=time;
        this.state=state;
    }
    public int compareTo(Time ob) {
        if(this.time==ob.time) return this.state-ob.state;
        else return this.time-ob.time;
    }
}

//강의실 배정
//Lecture Greedy Ex03(결혼식)과 같은 유형
public class Ex11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<Time> arr=new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            arr.add(new Time(start,'s'));
            arr.add(new Time(end,'e'));
        }
        Collections.sort(arr);
        int cnt=0, max=0;
        for(int i=0; i<arr.size(); i++) {
            if(arr.get(i).state=='s') cnt++;
            else cnt--;
            max=Math.max(max,cnt);
        }
        System.out.println(max);
    }
}
