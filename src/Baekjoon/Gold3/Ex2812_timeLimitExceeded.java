package Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//크게 만들기
public class Ex2812_timeLimitExceeded {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        String input = br.readLine();
        char[] ch = input.toCharArray();
        for(int i=0; i<n; i++) {
            arr.add(ch[i]-'0');
        }
        String answer="";
        int check=n-k;
        while(!arr.isEmpty()) {
            int max=0, idx=0;
            for(int i=0; i<=arr.size()-check; i++) {
                if(arr.get(i)>max) {
                    max=arr.get(i);
                    idx=i;
                }
            }
            answer+=max;
            for(int j=0; j<=idx; j++) {
                arr.remove(0);
            }
            check--;
        }
        System.out.println(answer);
    }
}
