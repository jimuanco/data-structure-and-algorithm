package Lecture.HashMap_TreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

//K번째 큰 수
public class Ex05_a {
    public int solution(int n, int k, int[] arr) {
        int answer=-1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int l=j+1; l<n; l++) {
                    Tset.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }
        int cnt=0;
//        Tset.remove(143);
//        System.out.println(Tset.size());
//        System.out.println("first : "+Tset.first());
//        System.out.println("last : "+Tset.last());
        for(int x : Tset) {
            cnt++;
            if(cnt==k) return x;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex05_a T = new Ex05_a();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(n, k, arr));
    }
}
