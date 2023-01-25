package Review.Lecture.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//소수(에라토스테네스 체)
public class Ex05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] ch=new int[n+1];
        int cnt=0;
        for(int i=2; i<=n; i++) {
            if(ch[i]==0) {
                cnt++;
                for(int j=i; j<=n; j=j+i) {
                    ch[j]=1;
                }
            }
        }
        System.out.println(cnt);
    }
}
