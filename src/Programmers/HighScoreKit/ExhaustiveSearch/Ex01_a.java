package Programmers.HighScoreKit.ExhaustiveSearch;

//최소직사각형(Lv1)
/*
sizes	result
[[60, 50], [30, 70], [60, 30], [80, 40]]	4000
[[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]	120
[[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]	133
 */
class Ex01_a {
    public static void main(String[] args) {
        int[][] sizes={{60,50},{30,70},{60,30},{80,40}};
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
        System.out.println(answer);;
    }
}