package Lecture.HashMap_TreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

//매출액의 종류(Hash, sliding window)
public class Ex03 {
    public ArrayList<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int lt=0, rt=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(rt<k) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
            rt++;
        }
        answer.add(map.size());
        for(int i=k; i<n; i++) {
            if(map.get(arr[lt]) > 1) {
                map.put(arr[lt], map.get(arr[lt])-1); //여기에 lt++ 하지마!
            } else {
                map.remove(arr[lt]);
            }
            lt++;
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            answer.add(map.size());
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Ex03 T = new Ex03();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for(int x : T.solution(n, k, arr)) {
            sb.append(x + " ");
        }
        System.out.print(sb);
        br.close();
    }
}
