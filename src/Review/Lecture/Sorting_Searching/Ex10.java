package Review.Lecture.Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//마구간 정하기(결정알고리즘)
public class Ex10 {
    public static int count(int[] arr, int dist) {
        int cnt=1;
        int ep=arr[0];
        for(int i=0; i<arr.length; i++) {
            if(arr[i]-ep>=dist) {
                cnt++;
                ep=arr[i];
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int answer=0;
        Arrays.sort(arr);
        int lt=1;
        int rt=arr[n-1];
        while(lt<=rt) {
            int mid=(lt+rt)/2;
            if(count(arr,mid)>=c) {
                answer=mid;
                lt=mid+1;
            } else rt=mid-1;
        }
        System.out.println(answer);
    }
}
