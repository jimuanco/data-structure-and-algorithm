package Review.Lecture.Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Least Recently Used
public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] cache=new int[s];
        for(int x : arr) {
            int pos=-1;
            for(int i=0; i<s; i++) {
                if(cache[i]==x) pos=i;
            }
            if(pos==-1) {
                for(int i=s-1; i>0; i--) {
                    cache[i]=cache[i-1];
                }
            }
            else {
                for(int i=pos; i>0; i--) {
                    cache[i]=cache[i-1];
                }
            }
            cache[0]=x;
        }
        StringBuilder sb=new StringBuilder();
        for(int x : cache) {
            sb.append(x+" ");
        }
        System.out.println(sb);
    }
}
