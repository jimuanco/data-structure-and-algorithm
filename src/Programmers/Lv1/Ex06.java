package Programmers.Lv1;

//바탕화면 정리(Lv1)
/*
wallpaper	result
[".#...", "..#..", "...#."]	[0, 1, 3, 4]
["..........", ".....#....", "......##..", "...##.....", "....#....."]	[1, 3, 5, 8]
[".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."]	[0, 0, 7, 9]
["..", "#."]	[1, 0, 2, 1]
 */
class Ex06 {
    public static void main(String[] args) {
        String[] wallpaper = {".#...", "..#..", "...#."};
        int[] answer = new int[4];
        int lux = Integer.MAX_VALUE, luy = Integer.MAX_VALUE, rdx = 0, rdy = 0;
        for(int i=0; i<wallpaper.length; i++) {
            for(int j=0; j<wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j)=='#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i);
                    rdy = Math.max(rdy, j);
                }
            }
        }
        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx+1;
        answer[3] = rdy+1;
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }
}
