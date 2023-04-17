package Programmers.Lv2;

//2020 카카오 인턴십
//수식 최대화(Lv2)
/*
expression	result
"100-200*300-500+20"	60420
"50*6-3*2"	300
 */

import java.util.*;

class Ex04 {
    public static void main(String[] args) {
        long answer = 0;
        String expression = "100-200*300-500+20";
        String[][] arithmetic = {{"*","+","-"}, {"*","-","+"}, {"+","-","*"}, {"-","+","*"}, {"+","*","-"}, {"-","*","+"}};
        ArrayList<String> arr = new ArrayList<String>();
        int start = 0;
        for(int i=0; i<expression.length(); i++) {
            if(expression.charAt(i) == '*' || expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                arr.add(expression.substring(start, i)); // 연산자 앞 숫자 추가
                arr.add(expression.charAt(i) + ""); // 연산자 추가
                start = i + 1;
            }
        }
        arr.add(expression.substring(start)); // 마지막 숫자 추가

        for(int i=0; i<arithmetic.length; i++) {
            ArrayList<String> sub_arr = new ArrayList<String>(arr);
            for(int k=0; k<3; k++) {
                for(int j=0; j<sub_arr.size(); j++) {
                    if(arithmetic[i][k].equals(sub_arr.get(j))) {
                        sub_arr.set(j-1, cal(sub_arr.get(j-1), sub_arr.get(j), sub_arr.get(j+1)));
                        sub_arr.remove(j);
                        sub_arr.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(sub_arr.get(0))));
        }
        System.out.println(answer);
    }

    static String cal(String num1, String ari, String num2) {
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);

        if(ari.equals("*")) {
            return n1 * n2 + "";
        } else if(ari.equals("+")) {
            return n1 + n2 + "";
        } else {
            return n1 - n2 + "";
        }
    }
}
