package Programmers.Lv1;

import java.util.Arrays;

//2018 KAKAO BLIND RECRUITMENT
//[1차] 비밀지도(Lv1)
/*
매개변수	값
n	5
arr1	[9, 20, 28, 18, 11]
arr2	[30, 1, 21, 17, 28]
출력	["#####","# # #", "### #", "# ##", "#####"]
매개변수	값
n	6
arr1	[46, 33, 33 ,22, 31, 50]
arr2	[27 ,56, 19, 14, 14, 10]
출력	["######", "### #", "## ##", " #### ", " #####", "### # "]
 */
class Ex05 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] answer = new String[n];
        Arrays.fill(answer,"");
        char[][] arr = new char[n][n];
        int idx = 0;
        for(int i=0; i<n; i++) {
            String a = Integer.toBinaryString(arr1[i]);
            Long b = Long.parseLong(a);
            String c = String.format("%0" + n + "d", b);
            for(int j=0; j<c.length(); j++) {
                if(c.charAt(j)=='1') {
                    arr[idx][j]='#';
                }
            }
            a = Integer.toBinaryString(arr2[i]);
            b = Long.parseLong(a);
            c = String.format("%0" + n + "d", b);
            for(int j=0; j<c.length(); j++) {
                if(arr[idx][j]=='#') continue;
                if(c.charAt(j)=='1') {
                    arr[idx][j]='#';
                }
            }
            idx++;
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j]!='#') {
                    answer[i]+=" ";
                } else {
                    answer[i]+=arr[i][j];
                }
            }
//            answer[i] = answer[i].replaceAll("\\s+", " ");
        }
        for(String x : answer) {
            System.out.print(x+", ");
        }
    }
}