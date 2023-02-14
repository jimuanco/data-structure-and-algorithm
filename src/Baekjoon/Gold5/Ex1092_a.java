package Baekjoon.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//배
//while문안 로직 잘 이해하기! (ArrayList 에서 remove하면 한 칸씩 땡겨와 짐)
//main 메서드 안에 if문에서 return 하니 걍 끝나네
public class Ex1092_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<Integer> crane = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }
        int m=Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(crane,Collections.reverseOrder());
        Collections.sort(box,Collections.reverseOrder());
        if(crane.get(0) < box.get(0)) {
            System.out.println(-1);
            return;
        }
        int answer=0;
        while(!box.isEmpty()) {
            int idx=0;
            for(int i=0; i<n;) {
                if(idx==box.size()) break;
                if(crane.get(i)>=box.get(idx)) {
                    box.remove(idx);
                    i++;
                } else idx++;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
