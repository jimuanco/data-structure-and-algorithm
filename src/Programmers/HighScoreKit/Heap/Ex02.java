package Programmers.HighScoreKit.Heap;

//디스크 컨트롤러(Lv3)
/*
jobs	return
[[0, 3], [1, 9], [2, 6]]	9
 */
import java.util.*;

class Ex02 {
    public static void main(String[] args) {
        int[][] jobs={{0,3},{1,9},{2,6}};
        int answer = 0;
//        Arrays.sort(jobs, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
        Arrays.sort(jobs, (o1,o2)->o1[0]-o2[0]);
//        PriorityQueue<int[]> pQ = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1]-o2[1];
//            }
//        });
        PriorityQueue<int[]> pQ = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        int jobsIdx=0;
        int end=0;
        int cnt=0;
        while(cnt<jobs.length) {
            while(jobsIdx<jobs.length && jobs[jobsIdx][0]<=end) {
                pQ.offer(jobs[jobsIdx++]);
            }
            if(pQ.isEmpty()) {
                end=jobs[jobsIdx][0];
            } else {
                int[] tmp = pQ.poll();
                answer+=tmp[1]+end-tmp[0];
                end+=tmp[1];
                cnt++;
            }
        }
        System.out.println(answer/jobs.length);
    }
}
