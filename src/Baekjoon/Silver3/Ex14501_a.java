package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Counsel {
    public int t,p;
    Counsel(int t, int p) {
        this.t=t;
        this.p=p;
    }
}

//퇴사
public class Ex14501_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<Counsel> arr = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int t=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            arr.add(new Counsel(t,p));
        }
        int[] dy=new int[n+1];
        for(int i=0; i<n; i++) {
            if(i+arr.get(i).t<n+1) {
                dy[i+arr.get(i).t]=Math.max(dy[i+arr.get(i).t],dy[i]+arr.get(i).p);
            }
            dy[i+1]=Math.max(dy[i+1],dy[i]); // 다음날 값을 최댓값으로 갱신, 최대 수익을 얻기 위해
        }
        System.out.println(dy[n]);
    }
}
