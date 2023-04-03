package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//게임
public class Ex1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        int num = (int) Math.floor(y*100/x);
        int lt=0, rt=1000000000, answer=-1;
        while(lt<=rt) {
            int mid = (lt+rt)/2;
            if((y+mid)*100/(x+mid)>=num+1) {
                rt=mid-1;
                answer=mid;
            } else {
                lt=mid+1;
            }
        }
        System.out.println(answer);
    }
}
