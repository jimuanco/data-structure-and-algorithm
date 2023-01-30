package Baekjoon.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//소수의 연속합
public class Ex1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] ch=new int[n+1];
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=2; i<=n; i++) {
            if(ch[i]==0) {
                arr.add(i);
                for(int j=i; j<=n; j=j+i) ch[j]=1;
            }
        }
        int answer=0, lt=0, sum=0;
        for(int rt=0; rt<arr.size(); rt++) {
            sum+=arr.get(rt);
            if(sum==n) answer++;
            while(sum>n) {
                sum-=arr.get(lt++);
                if(sum==n) answer++;
            }
        }
        System.out.println(answer);
    }
}
