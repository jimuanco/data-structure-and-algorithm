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

class Ex04_2_TLE {
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
        int p1=0, p2=0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(p1<X.length() && p2<Y.length()) {
            if(a[p1]==b[p2]) {
                arr.add(a[p1++]);
                p2++;
            } else if(a[p1]<b[p2]) p1++;
            else p2++;
        }
        Collections.sort(arr,Collections.reverseOrder());
        if(arr.size()==0) System.out.println(-1);
        if(arr.get(0)==0) System.out.println(0);
        for(int x : arr) {
            answer+=x;
        }
        System.out.println(answer);
    }
}
