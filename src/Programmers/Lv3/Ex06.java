package Programmers.Lv3;

//2019 카카오 개발자 겨울 인턴십
//징검다리 건너기(Lv3)
/*
stones	k	result
[2, 4, 5, 3, 2, 1, 4, 2, 5, 1]	3	3
 */

import java.util.Arrays;

class Ex06 {

    static boolean check(int mid, int[] stones, int k) {
        for(int i=0; i<stones.length; i++) {
            if(stones[i]-mid < 0) {
                int cnt = 0;
                while(i < stones.length && i<=i+k) {
                    if(stones[i]-mid<0) {
                        cnt++;
                    } else {
                        break;
                    }
                    if(cnt == k) return false;
                    i++;

                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        int answer = 0;
//        int max = 0;
//        for(int i=0; i<stones.length; i++) {
//            max = Math.max(max, stones[i]);
//        }
        int max= Arrays.stream(stones).max().getAsInt();
        int min = 1;
        while(min <= max) {
            int mid = (min+max)/2;
            if(check(mid, stones, k)) {
                answer = mid;
                min = mid+1;
            } else {
                max = mid-1;
            }
        }
        System.out.println(answer);
    }
}