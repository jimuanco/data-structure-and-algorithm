package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
    int x,y,r;
    Point(int x, int y, int r) {
        this.x=x;
        this.y=y;
        this.r=r;
    }
}

//터렛
//( (𝑥₂ - 𝑥₁)² + (𝑦₂ - 𝑦₁)² )½  을 구하기 위해 double 형으로 변수를 선언 -->이렇게 풀지말고 a처럼 풀어
public class Ex1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            Point a = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            Point b = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            double distance=Math.sqrt(Math.pow(Math.abs(a.x-b.x),2)+Math.pow(Math.abs(a.y-b.y),2)); //double 안쓰면 틀림
            if(distance==0) { //중심이 같을 때
                if(a.r==b.r) {
                    sb.append(-1+"\n"); //중심이 같고 크기가 같은 원
                } else {
                    sb.append(0+"\n"); //한 원이 다른 원안에 포함
                }
            } else { //중심이 다를 때
                if(distance<a.r+b.r) {
                    if(distance+a.r<b.r || distance+b.r<a.r) { //중심은 다르지만 한 원이 다른 원안에 포함(접점X)
                        sb.append(0+"\n");
                    } else if(distance+a.r==b.r || distance+b.r==a.r){ //중심은 다르지만 한 원이 다른 원안에 포함돼있으며 접점이 하나 있음
                        sb.append(1+"\n");
                    } else { //중심이 다른 두 원 이 겹쳐 접점 두개
                        sb.append(2+"\n");
                    }
                } else if(distance==a.r+b.r) { //한 원이 다른 원을 포함하지 않고 접점이 하나 있음
                    sb.append(1+"\n");
                } else if(distance>a.r+b.r) { //두 원이 떨어져 있어 아무 접점도 없음
                    sb.append(0+"\n");
                }
            }

        }
        System.out.println(sb);
    }
}
