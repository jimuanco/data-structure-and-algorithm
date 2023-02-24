package Baekjoon.Gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//제곱 ㄴㄴ 수
//1000000000000 1000001000000
//정답 607940
public class Ex1016_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int[] arr= new int[(int)(max-min+1)];
        int sqrt=(int)Math.sqrt(max);
        int cnt=0;
        for(long i=2; i<=sqrt; i++) {
            long square=i*i;
            long start= min%square == 0 ? min/square : min/square+1;
            for(long j=start; j*square<=max; j++) { //이 for문을 if(arr[(int)(start*square-min)]==0) 으로 감싸면은 오히려 cnt++를 조금 더 하게 됨(왜 이러지?)
                if(arr[(int)(j*square-min)]==1) continue; //이거 안해주면 cnt++를 더 하게 됨
                arr[(int)(j*square-min)]=1;
                cnt++;
            }
        }
        //주석 부분 쓸꺼면 위에 continue 없어도 돼
//        int cnt2=0;
//        for(int i=0; i<max-min+1; i++) {
//            if(arr[i]==0) cnt2++;
//        }
//        System.out.println(cnt2);
        System.out.println((max-min+1)-cnt);
    }
}
