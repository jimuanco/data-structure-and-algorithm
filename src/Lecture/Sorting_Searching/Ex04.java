package Lecture.Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Least Recently Used
//복습하면서 다시 품
public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> cm= new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(cm.size()==s) {
                cm.remove(0);
            }
            if(cm.contains(arr[i])) {
                cm.remove(cm.indexOf(arr[i]));
                cm.add(arr[i]);
            } else {
                cm.add(arr[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=cm.size()-1; i>=0; i--) {
            sb.append(cm.get(i)+" ");
        }
        System.out.println(sb);
    }
}
