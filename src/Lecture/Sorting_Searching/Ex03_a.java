package Lecture.Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//삽입 정렬
public class Ex03_a {
    public int[] solution(int n, int[] arr) {
        for(int i=1; i<n; i++) {
            int tmp=arr[i], j; //for문 밖에서 j 사용 위해
            for(j=i-1; j>=0; j--) {
                if(arr[j]>tmp) arr[j+1]=arr[j];
                else break;
            }
            arr[j+1]=tmp; //j가 멈춘 지점의 뒤에 tmp를 넣는다.(for문이 끝까지 돈다면(j가 -1이 됨) 0번 index에 넣음)
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        Ex03_a T = new Ex03_a();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for(int x : T.solution(n, arr)) {
            sb.append(x+" ");
        }
        br.close();
        System.out.print(sb);
    }
}
