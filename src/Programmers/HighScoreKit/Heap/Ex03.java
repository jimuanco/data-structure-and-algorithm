package Programmers.HighScoreKit.Heap;

//이중우선순위큐(Lv3)
/*
operations	return
["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]	[0,0]
["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]	[333, -45]
 */
import java.util.*;

class Ex03 {
    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] answer = new int[2];

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        for(String op : operations) {

            StringTokenizer st = new StringTokenizer(op);
            String indicator = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if(pQ.isEmpty() && indicator.equals("D")) continue;

            if(indicator.equals("I")) {
                pQ.offer(value);
                maxPQ.offer(value);
                continue;
            }

            if(value == -1) {

                maxPQ.remove(pQ.poll());

            } else {

                pQ.remove(maxPQ.poll());

            }
        }

        if(!pQ.isEmpty()) {
            answer[0] = maxPQ.poll();
            answer[1] = pQ.poll();
        }

        for(int x : answer) {
            System.out.print(x + " ");
        }
    }
}