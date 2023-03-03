package Baekjoon.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//사탕 게임
//문제가 좀 애매함
/*
2
C C
Y Y
의 경우 만약 색이 다른 인접한 두 칸을 교환 후 따진다면 1이 나와야 함
하지만 이 코드는 2가 나오는데 정답
 */
//N이 3부터라 괜찮음
public class Ex3085_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        char[][] arr = new char[n+1][n+1];
        for(int i=1; i<=n; i++) {
            String input = br.readLine();
            char[] ch = input.toCharArray();
            for(int j=1; j<=n; j++) {
                arr[i][j]=ch[j-1];
            }
        }
        int[] dx={0,1};
        int answer=0;
        int cnt=0;
        //행의 index +0,+1과 각각 바꾸며 행 별 최대 길이 확인 (여기서 바꾸지 않은것도 확인)
        while(cnt<n*n) { // 50*50*2*50*50 = 12,500,000
            for(int k=0; k<2; k++) {
                char tmp=' ';
                int x=0, y=0, x2=0, y2=0;
                for(int i=1; i<=n; i++) {
                    int cntLen=1;
                    for(int j=1; j<=n; j++) {
                        if(i==cnt/n+1 && j==cnt%n+1 && i+dx[k]>=1 && i+dx[k]<=n) {
                            tmp=arr[i][j];
                            arr[i][j]=arr[i+dx[k]][j];
                            arr[i+dx[k]][j]=tmp;
                            x=i;
                            y=j;
                            x2=i+dx[k];
                            y2=j;
                        }
                        if(arr[i][j]==arr[i][j-1]) {
                            cntLen++;
                        } else {
                            cntLen=1;
                        }
                        answer=Math.max(answer,cntLen);
                    }
                }
                arr[x2][y2]=arr[x][y];
                arr[x][y]=tmp;
            }
            cnt++;
        }
        cnt=0;
        //열의 index +1 과 각각 바꾸며 열 별 최대 길이 확인
        while(cnt<n*n) { //50*50*50*50 = 6,250,000
            char tmp=' ';
            int x=0, y=0, x2=0, y2=0;
            for(int i=1; i<=n; i++) {
                int cntLen=1;
                for(int j=1; j<=n; j++) {
                    if(i==cnt/n+1 && j==cnt%n+1 && i+1>=1 && i+1<=n) {
                        tmp=arr[j][i];
                        arr[j][i]=arr[j][i+1];
                        arr[j][i+1]=tmp;
                        x=j;
                        y=i;
                        x2=j;
                        y2=i+1;
                    }
                    if(arr[j][i]==arr[j-1][i]) {
                        cntLen++;
                    } else {
                        cntLen=1;
                    }
                    answer=Math.max(answer,cntLen);
                }
            }
            arr[x2][y2]=arr[x][y];
            arr[x][y]=tmp;
            cnt++;
        }

        cnt=0;
        //바로 다음열과 바꾸며 행 별 최대 길이 확인
        while(cnt<n*n) { //50*50*50*50 = 6,250,000
            for(int i=1; i<=n; i++) {
                int cntLen=1, x=0, y=0, x2=0, y2=0;
                char tmp=' ';
                for(int j=1; j<=n; j++) {
                    if(i==cnt/n+1 && j==cnt%n+1 && j+1>=1 && j+1<=n) {
                        tmp=arr[i][j];
                        arr[i][j]=arr[i][j+1];
                        arr[i][j+1]=tmp;
                        x=i;
                        y=j;
                        x2=i;
                        y2=j+1;
                    }
                    if(arr[i][j]==arr[i][j-1]) {
                        cntLen++;
                    } else {
                        cntLen=1;
                    }
                    answer=Math.max(answer,cntLen);
                }
                arr[x2][y2]=arr[x][y];
                arr[x][y]=tmp;
            }
            cnt++;
        }

        cnt=0;
        //바로 다음 행과 바꾸며 열 별 최대 길이 확인
        while(cnt<n*n) { //50*50*50*50 = 6,250,000
            for(int i=1; i<=n; i++) {
                int cntLen=1, x=0, y=0, x2=0, y2=0;
                char tmp=' ';
                for(int j=1; j<=n; j++) {
                    if(i==cnt/n+1 && j==cnt%n+1 && j+1>=1 && j+1<=n) {
                        tmp=arr[j][i];
                        arr[j][i]=arr[j+1][i];
                        arr[j+1][i]=tmp;
                        x=j;
                        y=i;
                        x2=j+1;
                        y2=i;
                    }
                    if(arr[j][i]==arr[j-1][i]) {
                        cntLen++;
                    } else {
                        cntLen=1;
                    }
                    answer=Math.max(answer,cntLen);
                }
                arr[x2][y2]=arr[x][y];
                arr[x][y]=tmp;
            }
            cnt++;
        }
        System.out.println(answer);
    }
}
