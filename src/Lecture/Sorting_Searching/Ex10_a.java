package Lecture.Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex10_a {
    public int count(int[] arr, int dist) {
        int cnt=1;
        int ep=arr[0];
        for(int i=1; i<arr.length; i++) {
            if(arr[i]-ep>=dist) {
                cnt++;
                ep=arr[i];
            }
        }
        return cnt;
    }

    public int solution(int n, int c, int[] arr) {
        int answer=0;
        Arrays.sort(arr);
        int lt= 1;
        int rt= arr[n-1];
        while(lt<=rt) {
            int mid=(lt+rt)/2;
            if(count(arr, mid)>=c) {
                answer=mid;
                lt=mid+1;
            } else rt=mid-1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex10_a T = new Ex10_a();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        System.out.print(T.solution(n, c, arr));
    }
}
