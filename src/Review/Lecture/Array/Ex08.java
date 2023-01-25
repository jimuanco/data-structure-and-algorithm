package Review.Lecture.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//등수구하기
public class Ex08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] answer=new int[n];
        for(int i=0; i<n; i++) {
            int cnt=1;
            for(int j=0; j<n; j++) {
                if(arr[j]>arr[i]) cnt++;
            }
            answer[i]=cnt;
        }
        StringBuilder sb = new StringBuilder();
        for(int x : answer) {
            sb.append(x+" ");
        }
        System.out.println(sb);
    }
}
