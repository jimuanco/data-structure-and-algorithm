package Lecture.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//결혼식
class Time2 implements Comparable<Time2> {
    public int time;
    public char state;
    Time2(int time, char state) {
        this.time=time;
        this.state=state;
    }
    @Override
    public int compareTo(Time2 o) {
        if(this.time==o.time) return this.state-o.state; //시간이 같을땐 e가 s보다 먼저와야(오름차순) cnt-- 부터 함
        else return this.time-o.time;
    }
}

public class Ex03_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Time2> arr = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.add(new Time2(s,'s'));
            arr.add(new Time2(e,'e'));
        }
        int answer=Integer.MIN_VALUE;
        Collections.sort(arr);
        int cnt=0;
        for(Time2 ob : arr) {
            if(ob.state=='s') cnt++;
            else cnt--;
            answer=Math.max(answer,cnt);
        }
        System.out.println(answer);
    }
}
