package Review.Lecture.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lecture implements Comparable<Lecture> {
    public int money, date;
    Lecture(int money, int date) {
        this.money=money;
        this.date=date;
    }
    @Override
    public int compareTo(Lecture ob) {
        return ob.date-this.date;
    }
}

//최대수입스케쥴(PriorityQueue)
public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<Lecture> arr=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int m=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            arr.add(new Lecture(m,d));
            if(d>max) max=d;
        }
        int answer=0;
        PriorityQueue<Integer> pQ=new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);
        int j=0;
        for(int i=max; i>=1; i--) {
            for( ; j<n; j++) {
                if(arr.get(j).date<i) break;
                pQ.offer(arr.get(j).money);
            }
            if(!pQ.isEmpty()) answer+=pQ.poll();
        }
        System.out.println(answer);
    }
}
