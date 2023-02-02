package Baekjoon.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

//숫자 카드2
//HashMap으로 품
public class Ex10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> map= new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int x=Integer.parseInt(st.nextToken());
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int m=Integer.parseInt(br.readLine());
        ArrayList<Integer> arr=new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int x=Integer.parseInt(st.nextToken());
            if(map.containsKey(x)) arr.add(map.get(x));
            else arr.add(0);
        }
        StringBuilder sb = new StringBuilder();
        for(int x : arr) {
            sb.append(x+" ");
        }
        System.out.println(sb);
    }
}
