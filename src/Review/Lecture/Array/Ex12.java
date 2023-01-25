package Review.Lecture.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//멘토링
public class Ex12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int answer=0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                int cnt=0;
                for(int k=0; k<m; k++) {
                    int pi=0, pj=0;
                    for(int s=0; s<n; s++) {
                        if(arr[k][s]==i) pi=s;
                        if(arr[k][s]==j) pj=s;
                    }
                    if(pi<pj) cnt++;
                }
                if(cnt==m) answer++;
            }
        }
        System.out.println(answer);
    }
}
