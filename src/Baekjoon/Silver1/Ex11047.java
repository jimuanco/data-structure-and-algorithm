package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

//동전 0
public class Ex11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            set.add(Integer.parseInt(st.nextToken()));
        }
        int sum=0, cnt=0;
        for (int x : set) {
            if(x<=k) { //젤 처음 x값이 k와 같은 경우를 고려해야함!!
                while(sum<k) {
                    sum+=x;
                    cnt++;
                }
                if(sum==k) {
                    System.out.println(cnt);
                    System.exit(0);
                }
                if(sum>k) {
                    sum-=x;
                    cnt--;
                }
            }
        }
        System.out.println(cnt);
    }
}
