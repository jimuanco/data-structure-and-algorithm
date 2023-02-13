package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//행렬
public class Ex1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[][] arr1=new int[n][m];
        int[][] arr2=new int[n][m];
        for(int i=0; i<n; i++) { //띄어쓰기 없는 2차원 int 배열 받을 때
            String input = br.readLine();
            char[] ch=input.toCharArray();
            for(int j=0; j<m; j++) {
                arr1[i][j]=ch[j]-'0';
            }
        }
        for(int i=0; i<n; i++) { //띄어쓰기 없는 2차원 int 배열 받을 때
            String input = br.readLine();
            char[] ch=input.toCharArray();
            for(int j=0; j<m; j++) {
                arr2[i][j]=ch[j]-'0';
            }
        }
        int answer=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i<n-2 && j<m-2 && arr1[i][j]!=arr2[i][j]) {
                    answer++;
                    for(int k=i; k<i+3; k++) {
                        for(int l=j; l<j+3; l++) {
                            if(arr1[k][l]==0) arr1[k][l]=1;
                            else arr1[k][l]=0;
                        }
                    }
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr1[i][j]!=arr2[i][j]) {
                    System.out.println(-1);
                    //System.exit(0)는 매우 정상적인 종료 방법. 처리할 것만 다 처리했다면 사용해도 됨. 이 함수가 호출되면 내부적으로 정리할 것들도 다 정리한 후 종료하기 때문에 강제 종료도 아니고, main 메서드가 끝나는 것과 마찬가지.
                    System.exit(0);
                }
            }
        }
        System.out.println(answer);
    }
}
