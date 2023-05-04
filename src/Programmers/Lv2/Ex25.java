package Programmers.Lv2;

//2018 KAKAO BLIND RECRUITMENT
//[3차] 압축(Lv2)

/*
msg	answer
KAKAO	[11, 1, 27, 15]
TOBEORNOTTOBEORTOBEORNOT	[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
ABABABABABABABAB	[1, 2, 27, 29, 28, 31, 30]
 */

import java.util.*;

class Ex25 {
    public static void main(String[] args) {
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        List<String> arr = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<26; i++) {
            String alpha = (char)(i+65)+"";
            arr.add(alpha);
        }
        for(int i=0; i<msg.length();) {
            int idx = 1;
            String tmp = msg.charAt(i)+"";
            while(i+idx<msg.length() && arr.contains(tmp+(msg.charAt(i+idx)+""))) {
                tmp += msg.charAt(i+idx);
                idx++;
            }
            answer.add(arr.indexOf(tmp)+1);
            if(i+idx<msg.length()) {
                arr.add(tmp+msg.charAt(i+idx));
            }
            i+=idx;
        }
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }
}
