package Programmers.Lv3;

//2018 KAKAO BLIND RECRUITMENT
//[1차] 셔틀버스(Lv3)
/*
n	t	m	timetable	answer
1	1	5	["08:00", "08:01", "08:02", "08:03"]	"09:00"
2	10	2	["09:10", "09:09", "08:00"]	"09:09"
2	1	2	["09:00", "09:00", "09:00", "09:00"]	"08:59"
1	1	5	["00:01", "00:01", "00:01", "00:01", "00:01"]	"00:00"
1	1	1	["23:59"]	"09:00"
10	60	45	["23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"]	"18:00"
 */

import java.util.*;

class Ex03_a {
    public static void main(String[] args) {
        int n = 1;
        int t = 1;
        int m = 5;
        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        // 시간을 분으로 바꿔 pQ에 넣어준다.
        for(String x : timetable) {
            int time = Integer.parseInt(x.split(":")[0]) * 60 + Integer.parseInt(x.split(":")[1]);
            pQ.offer(time);
        }

        int startTime = 9 * 60;
        int lastTime = 0;
        int cnt = 0;

        // 우선순위큐에서 가장 빨리 도착한 크루부터 확인.
        // 이때 버스 시간보다 이전에 도착한 크루는 버스에 태워주고(큐에서 꺼내고, 셔틀버스에 탄 인원수를 늘려준다.) 아니라면 다음 버스로 넘어간다.
        for(int i=0; i<n; i++) {
            cnt = 0;
            while(!pQ.isEmpty()) {
                int currentTime = pQ.peek();
                if(currentTime <= startTime && cnt < m) {
                    pQ.poll();
                    cnt++;
                } else break;

                // 현재 셔틀 버스에 크루가 탈 때마다 마지막 시간을 재계산 해줌.
                // 해당 크루 보다 1분 먼저 도착하는 것이 가장 마지막으로 도착하여 해당 버스에 탈 수 있는 시간이므로 현재 크루의 시간 -1을 마지막 시간으로 재설정.
                lastTime = currentTime - 1;
            }
            startTime += t;
        }

        // 마지막 셔틀 버스에 탄 인원이 m보다 작다면, 해당 셔틀 버스에 콘이 탈 수 있다는 의미.
        // 콘이 마지막 버스에 타게 되고, 탑승 인원이 꽉 채워지지 않은 경우라면 콘은 버스 도착시간에 동시에 와도 된다.
        if(cnt < m) {
            lastTime = startTime - t;
        }

        //%: 명령의 시작
        //0: 채워질 문자
        //2: 총 자리수
        //d: 10진수(정수)
        String hour = String.format("%02d", lastTime / 60);
        String minute = String.format("%02d", lastTime % 60);

        System.out.println(hour + ":" + minute);
    }
}