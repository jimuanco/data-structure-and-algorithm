package Baekjoon.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//단어 수학

//ASCII(아스키) -> 숫자는 48 ~ 57, 영문 대문자는 65 ~ 90, 영문 소문자는 97 ~ 122 (영문 소문자에서 32를 빼면 영문 대문자가 된다.)
//밑에 설명
public class Ex1339_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        int[] alpha = new int[26];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i]=st.nextToken();
        }
        for(int i=0; i<n; i++) {
            int tmp=(int)Math.pow(10,arr[i].length()-1); //거듭제곱
            for(int j=0; j<arr[i].length(); j++) {
                alpha[arr[i].charAt(j)-65]+=tmp; //arr[i].charAt(j)-65 앞에 (int) 없어도 됨
                tmp /=10;
            }
        }
        Arrays.sort(alpha);
        int idx=9;
        int sum=0;
        for(int i=alpha.length-1; i>=0; i--) {
            if(alpha[i]==0) break;
            sum+=alpha[i]*idx;
            idx--;
        }
        System.out.println(sum);
    }
}

//예시
//GCF
//ACDEB
//
//이 문제의 정답은 'max'값을 찾는 것. 따라서 높은 자릿수에 높은 값(9~0) 을 부여.
//
//GCF는 총 3자리이다. 따라서 100부터 시작.
//100G, 10C, 1F
//ACDEB는 총 5자리이다. 따라서 10000부터 시작.
//10000A, 1000C, 100D, 10E, 1B
//
//GCF의 값과 ACDEB의 값을 더해보자.
//10000A, 1B, 1010C, 100D, 10E, 1F, 100G
//
//나온 값을 26개의 int형 배열을 생성하여 넣어준후, 정렬한다. (A-Z가 총 26개)
//
//높은값부터 9~0씩 곱하면 답을 구해낼 수 있다.