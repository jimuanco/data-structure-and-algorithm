package Review.Lecture.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Time2 implements Comparable<Time2> {
    public int time;
    public char state;
    Time2(int time, char state) {
        this.time=time;
        this.state=state;
    }
    @Override
    public int compareTo(Time2 ob) {
        if(this.time==ob.time) return this.state-ob.state;
        else return this.time-ob.time;
    }
}

//결혼식
public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<Time2> arr = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            arr.add(new Time2(start,'s'));
            arr.add(new Time2(end,'e'));
        }
        Collections.sort(arr);
        int answer=Integer.MIN_VALUE, cnt=0;
        for(Time2 ob : arr) {
            if(ob.state=='s') cnt++;
            else cnt--;
            answer=Math.max(answer,cnt);
        }
        System.out.println(answer);
    }
}
