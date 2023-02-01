package Baekjoon.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//좋다
//HashMap으론 도저히 못풀겠다..
public class Ex1253_wrong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer,Integer> map=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        for(int i=0; i<n; i++) {
            int x=Integer.parseInt(st.nextToken());
            arr[i]=x;
            map.put(x,map.getOrDefault(x,0)+1);
            map2.put(x,map.getOrDefault(x,0)+1);
        }
        int answer=0,lt=0,rt=arr.length-1;
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                int num=arr[i]+arr[j];
                if(map.containsKey(num)) {
                    if(arr[i]==0 && arr[j]==0) {
                        if(map2.get(num)>2) {
                            answer+=map.get(num)-2;
                            map.put(num,2);
                            continue;
                        }
                        continue;
                    }
                    if(num!=0 && (num==arr[i] || num==arr[j])) {
                        if(map2.get(num)>1) {
                            if(map2.containsKey(0) && map2.get(0)>1) {
                                answer+=map.get(num);
                                map.remove(num);
                                continue;
                            }
                            answer+=map.get(num)-1;
                            map.put(num,1);
                            continue;
                        }
                        continue;
                    }
                    answer+=map.get(num);
                    map.remove(num);
                }
            }
        }
        System.out.println(answer);
    }
}
