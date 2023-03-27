package Programmers.Lv1;

//숫자 짝꿍(Lv1)
/*
X	Y	result
"100"	"2345"	"-1"
"100"	"203045"	"0"
"100"	"123450"	"10"
"12321"	"42531"	"321"
"5525"	"1255"	"552"
 */
import java.util.*;

class Ex04_3_TLE {
    public static void main(String[] args) {
        String X = "12321";
        String Y = "42531";
        String answer = "";
        int[] a = new int[X.length()];
        int[] b = new int[Y.length()];
        for(int i=0; i<X.length(); i++) {
            a[i]=X.charAt(i)-48;
        }
        for(int i=0; i<Y.length(); i++) {
            b[i]=Y.charAt(i)-48;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int p1=X.length()-1, p2=Y.length()-1;
        while(p1>=0 && p2>=0) {
            if(a[p1]==b[p2]) {
                answer+=a[p1--];
                p2--;
            } else if(a[p1]<b[p2]) p2--;
            else p1--;
        }
        if(answer.length()==0) System.out.println(-1);
        if(answer.charAt(0)=='0') System.out.println(0);
        System.out.println(answer);
    }
}
