package Review.Lecture.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//임시반장 정하기
public class Ex11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][6];
        StringTokenizer st;
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=5; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int answer=0, max=0;
        for(int i=1; i<=n; i++) {
            int cnt=0;
            for(int j=1; j<=n; j++) {
                for(int k=1; k<=5; k++) {
                    if(arr[i][k]==arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt>max) {
                max=cnt;
                answer=i;
            }
        }
        System.out.println(answer);
    }
}
