package Baekjoon.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//수들의 합
public class Ex1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long n = Long.parseLong(br.readLine());
        long sum=0, num=1;
        while(sum<n) {
            sum+=num;
            if(sum==n) {
                System.out.println(num); //갯수의 최대값을 구하기 위해 자연수 1부터 순서대로(num) 더해 나가기 때문에 sum==n 일 시 num을 그대로 출력하면 갯수임
                break;
            } else if(sum>n){
                System.out.println(num-1); // 자연수 1부터 순서대로 더해왔기 때문에 sum>n일 시 갯수를 하나 빼줘야함 (즉, 최근 더한 값을 빼고 그 전값을 더 크게 해서 더해줘야 sum==n을 만족하는 최대 갯수를 구할 수 있음)
                break;
            }
            num++;
        }
    }
}
