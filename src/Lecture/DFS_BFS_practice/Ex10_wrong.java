package Lecture.DFS_BFS_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//미로탐색(DFS)
public class Ex10_wrong {

    static int answer=0;

    public static void DFS(int i, int j, int[][] arr) {
        if(i==6 && j==6) {
            answer++;
        } else {
            if(j<6 && arr[i][j+1]==0) {
                arr[i][j+1]=1;
                DFS(i,j+1,arr);
                arr[i][j+1]=0;
            }
            if(i<6 && arr[i+1][j]==0) {
                arr[i+1][j]=1;
                DFS(i+1,j,arr);
                arr[i+1][j]=0;
            }
            if(j>0 && arr[i][j-1]==0) {
                arr[i][j-1]=1;
                DFS(i,j-1,arr);
                arr[i][j-1]=0;
            }
            if(i>0 && arr[i-1][j]==0) {
                arr[i-1][j]=1;
                DFS(i-1,j,arr);
                arr[i-1][j]=0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[7][7];
        for(int i=0; i<7; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<7; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        DFS(0,0,arr);
        System.out.println(answer);
    }
}
