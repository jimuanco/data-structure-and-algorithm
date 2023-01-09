package Lecture.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//아예 문제를 잘 못 이해함.
public class Ex12_wrong {

    public int solution(int n, int m, int[][] arr) {
        int answer = 0;
        for(int i=0; i<m; i++) {
            if (i < n) {
                for(int j=i; j<n; j++) {
                    int cnt = m;
                    for(int k=0; k<m; k++) {
                        if(arr[k][i] > arr[k][j])
                            cnt++;
                        else if(arr[k][i] < arr[k][j])
                            cnt--;
                    }
                    if(cnt == (2*m) || cnt == 0)
                        answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        Ex12_wrong T = new Ex12_wrong();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(T.solution(n, m, arr));
        br.close();
    }
}
