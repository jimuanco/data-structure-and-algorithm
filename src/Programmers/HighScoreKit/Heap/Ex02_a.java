package Programmers.HighScoreKit.Heap;

//디스크 컨트롤러(Lv3)
/*
jobs	return
[[0, 3], [1, 9], [2, 6]]	9
 */
import java.util.*;

class Ex02_a {
    public static void main(String[] args) {
        int[][] jobs={{0,3},{1,9},{2,6}};
        int answer = 0;
//        Arrays.sort(jobs, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
        //요청시간 오름차순
        Arrays.sort(jobs, (o1,o2)->o1[0]-o2[0]);
//        PriorityQueue<int[]> pQ = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1]-o2[1];
//            }
//        });
        //처리 시간 오름차순
        PriorityQueue<int[]> pQ = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        int jobsIdx=0; //jobs배열의 index
        int end=0; //수행되고난 직후의 시간
        int cnt=0; //수행된 요청 갯수
        //요청이 모두 수행될 때까지 반복
        while(cnt<jobs.length) {
            //하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청을 큐에 넣음
            while(jobsIdx<jobs.length && jobs[jobsIdx][0]<=end) {
                pQ.offer(jobs[jobsIdx++]);
            }
            //큐가 비어있다면 작업 완료(end) 이후에 다시 요청이 들어온다는 의미
            //end를 요청의 가장 처음으로 맞춤
            if(pQ.isEmpty()) {
                end=jobs[jobsIdx][0];
            //작업이 끝나기전(end 이전) 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
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
