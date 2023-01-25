package Lecture.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//점수계산
public class Ex07_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int answer=0,cnt=0;
        for(int i=0; i<n; i++) {
            if(arr[i]==1) {
                cnt++;
                answer+=cnt;
            } else cnt=0;
        }
        System.out.println(answer);
    }
}
