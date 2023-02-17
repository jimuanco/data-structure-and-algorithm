package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//2xN 예쁜 타일링
public class Ex18230_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pQ1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pQ2 = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<a; i++) {
            pQ1.offer(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<b; i++) {
            pQ2.offer(Integer.parseInt(st.nextToken()));
        }
        int answer=0;
        if(n%2==1) {
            answer+=pQ1.poll();
            for(int i=0; i<n-1; i+=2) {
                if(pQ1.size()>1 && pQ2.size()>0) {
                    int tmp1=pQ1.poll();
                    int tmp2=pQ1.poll();
                    int tmp3=pQ2.poll();
                    if(tmp1+tmp2>tmp3) {
                        answer+=(tmp1+tmp2);
                        pQ2.offer(tmp3);
                    } else {
                        answer+=tmp3;
                        pQ1.offer(tmp1);
                        pQ1.offer(tmp2);
                    }
                } else if(pQ1.size()<=1) {
                    answer+=pQ2.poll();
                } else if(pQ2.isEmpty()) {
                    answer+=(pQ1.poll()+pQ1.poll());
                }
            }
        } else {
            for(int i=0; i<n; i+=2) {
                if(pQ1.size()>1 && pQ2.size()>0) {
                    int tmp1=pQ1.poll();
                    int tmp2=pQ1.poll();
                    int tmp3=pQ2.poll();
                    if(tmp1+tmp2>tmp3) {
                        answer+=(tmp1+tmp2);
                        pQ2.offer(tmp3);
                    } else {
                        answer+=tmp3;
                        pQ1.offer(tmp1);
                        pQ1.offer(tmp2);
                    }
                } else if(pQ1.size()<=1) {
                    answer+=pQ2.poll();
                } else if(pQ2.isEmpty()) {
                    answer+=(pQ1.poll()+pQ1.poll());
                }
            }
        }
        System.out.println(answer);
    }
}
