package Programmers.HighScoreKit.ExhaustiveSearch;

import java.util.*;

//소수 찾기(Lv2)
/*
numbers	return
"17"	3
"011"	2
 */
class Ex03 {
    static HashSet<Integer> set;
    static boolean isPrime(int num) {
        if(num==1) return false;
        for(int i=2; i<=(int)Math.sqrt(num); i++) { //부등호 주의!!
            if(num%i==0) return false;
        }
        return true;
    }

    static void DFS(int L, int[] arr, int[] ch, int m, int[] pm) {
        if(L==m) {
            String strNum="";
            for(int x : pm) {
                strNum+=x;
            }
            if(strNum.charAt(0)=='0') return;
            set.add(Integer.parseInt(strNum));
        } else {
            for(int i=0; i<arr.length; i++) {
                if(ch[i]==0) {
                    ch[i]=1;
                    pm[L]=arr[i];
                    DFS(L+1,arr,ch,m,pm);
                    ch[i]=0;
                }
            }
        }
    }
    public static void main(String[] args) {
        String numbers="17";
        int answer = 0;
        int[] arr = new int[numbers.length()];
        int[] ch = new int[numbers.length()];
        for(int i=0; i<numbers.length(); i++) {
            arr[i]=numbers.charAt(i)-48;
        }
        for(int i=1; i<=numbers.length(); i++) {
            int[] pm=new int[i];
            set = new HashSet<>();
            DFS(0,arr,ch,i,pm);
            for(int x : set) {
                if(isPrime(x)) {
                    answer++;
                }
            }
        }
        System.out.println(answer);;
    }
}
