package Lecture.TwoPointers_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//연속된 자연수의 합
//풀이는 for문으로 풀었음 함 봐바
//수학적으로 풀 수도 있음
public class Ex05 {
    public int solution(int n) {
        int answer = 0, sum=1, lt=1, rt=1;
        while(lt<=n/2+1) {
            sum += rt+1;
            if(sum<n) {
                rt++;
            } else if(sum==n) {
                lt++;
                answer++;
                sum=lt;
                rt=lt;
            } else {
                lt++;
                sum=lt;
                rt=lt;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex05 T = new Ex05();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(T.solution(n));

    }
}
