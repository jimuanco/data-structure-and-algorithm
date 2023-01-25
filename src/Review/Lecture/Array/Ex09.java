package Review.Lecture.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//격자판 최대합
public class Ex09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int answer=Integer.MIN_VALUE;
        int sumH=0, sumV=0, sumD1=0, sumD2=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sumH+=arr[i][j];
                sumV+=arr[j][i];
            }
            sumD1+=arr[i][i];
            sumD2+=arr[i][n-i-1];
            answer=Math.max(answer,sumH);
            answer=Math.max(answer,sumV);
            sumH=0;
            sumV=0;
        }
        answer=Math.max(answer,sumD1);
        answer=Math.max(answer,sumD2);
        System.out.println(answer);
    }
}
