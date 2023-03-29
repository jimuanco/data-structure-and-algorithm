package Programmers.HighScoreKit.ExhaustiveSearch;

//모음사전
/*
word	result
"AAAAE"	6
"AAAE"	10
"I"	1563
"EIO"	1189
 */
class Ex07_a {
    public static void main(String[] args) {
        String word = "EIO";
        int answer = word.length();
        String str = "AEIOU";
        int[] x = {781, 156, 31, 6, 1};
        int idx;
        for(int i=0; i<word.length(); i++) {
            idx = str.indexOf(word.charAt(i));
            answer += x[i] * idx;
        }
        System.out.println(answer);
    }
}