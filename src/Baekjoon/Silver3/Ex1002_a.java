package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//터렛
//( (𝑥₂ - 𝑥₁)² + (𝑦₂ - 𝑦₁)² )½  을 구하기 위해 double 형으로 변수를 선언 하지말자.
//좌표를 비교할 때 우리는 == 연산자를 써야하는데 double 형(또는 float형) 의 경우는 약간의 오차가 발생할 수 있다.
//이는 부동소수점 타입이 정확한 값이 아니라 근사치로 처리하기 때문
//이러한 특성으로 인해 조금의 오차가 있을 경우 두 실수는 같지 않을 수도 있다.
public class Ex1002_a {
    //접점 개수 구하는 메서드
    static int tangent_point(int x1, int y1, int r1, int x2, int y2, int r2) {
        int distance_pow=(int)(Math.pow(x2-x1,2)+Math.pow(y2-y1,2)); //중점과 거리 distance의 제곱
        if(x1==x2 && y1==y2 && r1==r2) { //중점이 같으면서 반지름도 같은 경우
            return -1;
        } else if(distance_pow>Math.pow(r1+r2,2)) { //두 원의 반지름의 합보다 중점간 거리가 더 긴 경우
            return 0;
        } else if(distance_pow<Math.pow(r1-r2,2)) { //원 안에 원이 있으나 내접하지 않은 경우
            return 0;
        } else if(distance_pow==Math.pow(r1-r2,2)) { //내접
            return 1;
        } else if(distance_pow==Math.pow(r1+r2,2)) { //외접
            return 1;
        } else {
            return 2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(t-->0) {
            st = new StringTokenizer(br.readLine());

            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int r1=Integer.parseInt(st.nextToken());

            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());
            int r2=Integer.parseInt(st.nextToken());

            sb.append(tangent_point(x1,y1,r1,x2,y2,r2)+"\n");
        }
        System.out.println(sb);
    }
}
