package Programmers.Lv1;

//최소직사각형
//완전탐색
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxV=0, maxH=0;
        for(int i=0; i<sizes.length; i++) {
            int[] size = sizes[i]; //익히기!
            //각각 가로 세로 비교
            int max=Math.max(size[0],size[1]);
            int min=Math.min(size[0],size[1]);
            //들어온 값들 중 가로,세로 최대값
            maxV=Math.max(maxV,max);
            maxH=Math.max(maxH,min);
        }
        answer=maxV*maxH;
        return answer;
    }
}
