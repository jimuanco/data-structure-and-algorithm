package Lecture.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//응급실
class Person {
    int id;
    int priority;
    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class Ex08_a {
    public int solution(int n, int m, int[] arr) {
        int answer=0;
        Queue<Person> Q = new LinkedList<>();
        for(int i=0; i<n; i++) Q.offer(new Person(i, arr[i]));
        while(!Q.isEmpty()) {
            Person tmp = Q.poll();
            for(Person x : Q) {
                if(x.priority>tmp.priority) {
                    Q.offer(tmp);
                    tmp=null;
                    break;
                }
            }
            if(tmp!=null) {
                answer++;
                if(tmp.id==m) return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex08_a T = new Ex08_a();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        System.out.print(T.solution(n, m, arr));
    }
}
