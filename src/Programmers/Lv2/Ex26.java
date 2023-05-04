package Programmers.Lv2;

//2018 KAKAO BLIND RECRUITMENT
//[3차] 파일명 정렬(Lv2)

/*
입력: ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
출력: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]

입력: ["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]
출력: ["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]
 */

import java.util.*;

class Ex26 {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] answer = {};
        String[][] arr = new String[files.length][3];
        for(int i=0; i<files.length; i++) {

            //숫자 판별 정규식
            String tmp = files[i].replaceAll("[0-9]",",");

            int ns = tmp.indexOf(",");
            int ne = 0;
            int cnt = 0;
            for(int j=ns; j<tmp.length(); j++) {
                cnt++;
                ne=j;
                if(cnt>5 || tmp.charAt(j)!=',') {
                    ne-=1;
                    break;
                }
            }
            arr[i][0]=files[i].substring(0,ns);
            arr[i][1]=files[i].substring(ns,ne+1);
            arr[i][2]=files[i].substring(ne+1);
        }
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {

                //대소문자 상관없이 같은지
                if(o1[0].equalsIgnoreCase(o2[0])) {
                    return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                } else {
                    //대소문자 상관없이 정렬 해줘야 한다.
                    return o1[0].toUpperCase().compareTo(o2[0].toUpperCase());
                }
            }
        });

        answer = new String[arr.length];

        for(int i=0; i<arr.length; i++) {
            answer[i] = arr[i][0]+arr[i][1]+arr[i][2];
        }

        for(String x : answer) {
            System.out.print(x+" ");
        }
    }
}