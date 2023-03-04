package Programmers.Lv1;

import java.util.*;

//개인정보 수집 유효기간
/*
today	terms	privacies	result
"2022.05.19"	["A 6", "B 12", "C 3"]	["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]	[1, 3]
"2020.01.01"	["Z 3", "D 5"]	["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]	[1, 4, 5]
 */
//문자열 비교 equals 주의 !!!!!!!!!!!!!!!!!
class Ex01 {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<privacies.length; i++) {
            for(int j=0; j<terms.length; j++) {
//                System.out.print(terms[j].substring(0,1));
//                System.out.print(privacies[i].substring(11));
//                System.out.println(terms[j].substring(0,1)==privacies[i].substring(11));
//                System.out.println(terms[j].substring(0,1).equals(privacies[i].substring(11));
                if(terms[j].substring(0,1).equals(privacies[i].substring(11))) {

                    int year = Integer.parseInt(privacies[i].substring(0,4));
                    int month = Integer.parseInt(privacies[i].substring(5,7)) + Integer.parseInt(terms[j].substring(2));
                    int day = Integer.parseInt(privacies[i].substring(8,10));

                    if(day == 1) {
                        day = 28;
                        month--;
                    } else {
                        day--;
                    }

                    if(month > 12) {
                        year += month / 12; //이거랑 아래 순서 바뀌면 안됨
                        month = month % 12;
                        if(month == 0) { //이거 없으면 17번 TC 통과 못함 (month가 24일 경우 year는 1증가하고 month는 12가 됨)
                            month = 12;
                            year--;
                        }
                    }

                    int nowYear = Integer.parseInt(today.substring(0,4));
                    int nowMonth = Integer.parseInt(today.substring(5,7));
                    int nowDay = Integer.parseInt(today.substring(8));

                    if(nowYear > year) {
                        arr.add(i+1);
                        break;
                    }

                    if(nowYear == year && nowMonth > month) {
                        arr.add(i+1);
                        break;
                    }

                    if(nowYear == year && nowMonth == month && nowDay > day) {
                        arr.add(i+1);
                        break;
                    }
                }
            }
        }

        answer=new int[arr.size()];
        for(int i=0; i<arr.size(); i++) {
            answer[i]=arr.get(i);
        }

        for(int x : answer) {
            System.out.println(x);
        }
    }
}
