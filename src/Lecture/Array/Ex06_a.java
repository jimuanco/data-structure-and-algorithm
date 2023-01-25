package Lecture.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//뒤집은 소수
public class Ex06_a {
    public static boolean isPrime(int num) {
        if(num==1) return false;
        for(int i=2; i<=(int)Math.sqrt(num); i++) { //소수 판별시 제곱근이랑 같을때까지만
            if(num%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int tmp=arr[i];
            int res=0;
            while(tmp>0) { //숫자 뒤집기
                int t=tmp%10; //1의 자리
                res=res*10+t; //1의 자리를 맨앞에
                tmp=tmp/10; //1의자리 제외한 부분 -> 1의 자리까지오면 0이 됨
            }
            if(isPrime(res)) answer.add(res);
        }
        StringBuilder sb = new StringBuilder();
        for(int x : answer) {
            sb.append(x+" ");
        }
        System.out.println(sb);
    }
}
