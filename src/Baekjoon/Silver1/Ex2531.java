package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//회전 초밥
public class Ex2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken()); //이건 왜 안쓰이냐?
        int k=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int[] arr=new int[n+k-1];
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        int cnt=0;
        for(int i=n; i<n+k-1; i++) {
            arr[i]=arr[cnt++];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int answer=0;
        for(int i=0; i<k; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        map.put(c,map.getOrDefault(c,0)+1);
        answer=map.size();
        for(int i=k; i<n+k-1; i++) {
            map.put(arr[i-k],map.get(arr[i-k])-1);
            if(map.get(arr[i-k])==0) map.remove(arr[i-k]);
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            map.put(c,map.getOrDefault(c,0)+1);
            answer=Math.max(answer,map.size());
        }
        System.out.println(answer);
    }
}
