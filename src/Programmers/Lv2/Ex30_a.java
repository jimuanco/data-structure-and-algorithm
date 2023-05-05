package Programmers.Lv2;

//Summer/Winter Coding(~2018)
//방문 길이(Lv2)

/*
dirs	answer
"ULURRDLLU"	7
"LULLLLLLU"	7
 */

import java.util.*;

class Ex30_a {
    public static void main(String[] args) {
        String dirs = "LULLLLLLU";
        int answer = 0;
        Set<String> set = new HashSet<>();
        int x=5, y=5;
        for(char d : dirs.toCharArray()) {
            String road = "";
            int nx = x;
            int ny = y;
            if(d=='U') {
                nx--;
                road += nx;
                road += y;
                road += x;
                road += y;
            } else if(d=='D') {
                nx++;
                road += x;
                road += y;
                road += nx;
                road += y;
            } else if(d=='R') {
                ny++;
                road += x;
                road += y;
                road += x;
                road += ny;
            } else if(d=='L') {
                ny--;
                road += x;
                road += ny;
                road += x;
                road += y;
            }
            if(nx<0 || nx>=11 || ny<0 || ny>=11) {
                continue;
            }
            set.add(road);
            x = nx;
            y = ny;
        }
        answer = set.size();
        System.out.println(answer);
    }
}