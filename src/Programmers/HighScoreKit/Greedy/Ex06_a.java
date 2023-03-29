package Programmers.HighScoreKit.Greedy;

//단속카메라(Lv3)
/*
routes	return
[[-20,-15], [-14,-5], [-18,-13], [-5,-3]]	2
 */

/*
테스트 케이스
print(solution([[-2,-1], [1,2],[-3,0]])) #2
print(solution([[0,0],])) #1
print(solution([[0,1], [0,1], [1,2]])) #1
print(solution([[0,1], [2,3], [4,5], [6,7]])) #4
print(solution([[-20,-15], [-14,-5], [-18,-13], [-5,-3]])) #2
print(solution([[-20,15], [-14,-5], [-18,-13], [-5,-3]])) #2
print(solution([[-20,15], [-20,-15], [-14,-5], [-18,-13], [-5,-3]])) #2
 */

/*
카메라는 항상 진출지점을 기준으로 설치되어야한다. 만약, 가장 먼저 진입한 차량의 종점구간에 카메라가 설치된다면,
중간에 진입한 차량이 진출구간이전에 진출하였다면, 카메라가 단속을 하지 못하게 된다. 어차피 진출한 지점에 카메라를
설치해야한다면, 가장 먼저 진출한 차량지점에 카메라를 설치하게된다. 그럼 모든 위치를 커버할 수 있게된다.
진입지점에서는 카메라를 볼 수 없으므로, 진출지점에는 무조건 카메라가 존재해야한다. 그렇기 때문에 가장 먼저 진출한
순서대로 카메라가 설치되어야한다.
 */

import java.util.*;

class Ex06_a {
    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> (o1[1]-o2[1]));
        int cam = Integer.MIN_VALUE;
        for(int[] route : routes) {
            if(cam < route[0]) {
                cam = route[1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
