package Review.Lecture.TwoPointers_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//두 배열 합치기
public class Ex01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr1=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr1[i]=Integer.parseInt(st.nextToken());
        }
        int m=Integer.parseInt(br.readLine());
        int[] arr2=new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            arr2[i]=Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> answer=new ArrayList<>();
        int p1=0, p2=0;
        while(p1<n && p2<m) {
            if(arr1[p1]<arr2[p2]) answer.add(arr1[p1++]);
            else answer.add(arr2[p2++]);
        }
        while(p1<n) answer.add(arr1[p1++]);
        while(p2<m) answer.add(arr2[p2++]);

        StringBuilder sb = new StringBuilder();
        for(int x : answer) {
            sb.append(x+" ");
        }
        System.out.println(sb);
    }
}
