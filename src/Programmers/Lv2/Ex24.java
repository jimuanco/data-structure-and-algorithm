package Programmers.Lv2;

//2018 KAKAO BLIND RECRUITMENT
//[3차] 방금그곡(Lv2)

/*
m	musicinfos	answer
"ABCDEFG"	["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]	"HELLO"
"CC#BCC#BCC#BCC#B"	["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]	"FOO"
"ABC"	["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]	"WORLD"
 */

import java.util.*;

class Ex24 {
    public static void main(String[] args) {
        String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        // 조건이 일치하는 음악이 없을 때에는 “(None)”을 반환한다.
        String answer = "(None)";
        int play_time = 0;
        for(int i=0; i<musicinfos.length; i++) {
            String[] strings = musicinfos[i].split(",");
            int start = Integer.parseInt(strings[0].split(":")[0])*60
                    + Integer.parseInt(strings[0].split(":")[1]);
            int end = Integer.parseInt(strings[1].split(":")[0])*60
                    + Integer.parseInt(strings[1].split(":")[1]);
            int time = end - start;

//            int n = strings[3].replaceAll(String.valueOf('#'),"").length();
            int n = strings[3].replaceAll("#","").length();
            String[] notes = new String[n];

            int idx = 0;
            for(int j=0; j<strings[3].length(); j++) {
                notes[idx] = strings[3].charAt(j)+"";
                if(j+1 < strings[3].length() && strings[3].charAt(j+1)=='#') {
                    notes[idx] += "#";
                    j++;
                }
                idx++;
            }

            String music = "";
            String[] tmp;
            int t = time;

            if(time <= notes.length) {
                tmp = Arrays.copyOfRange(notes, 0, time);
                for(String x : tmp) {
                    music += x;
                    music +=" ";
                }
            } else {
                while(true) {
                    for(String x : notes) {
                        music += x;
                        music +=" ";
                    }
                    t -= notes.length;
                    if(t <= notes.length) {
                        tmp = Arrays.copyOfRange(notes, 0, time);
                        for(String x : tmp) {
                            music += x;
                            music += " ";
                        }
                        break;
                    }
                }
            }
            String new_m = "";
            for(int j=0; j<m.length(); j++) {
                new_m += m.charAt(j)+"";
                new_m += " ";
            }
            new_m = new_m.replaceAll(" #","#");

            if(music.contains(new_m)) {

                // 조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다.
                // 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
                if(time > play_time) {
                    play_time = time;
                    answer = strings[2];
                }
            }
        }
        System.out.println(answer);
    }
}
