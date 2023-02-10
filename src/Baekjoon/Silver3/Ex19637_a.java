package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Power {
    String name;
    int value;
    Power(String name, int value) {
        this.name=name;
        this.value=value;
    }
}

//IF문 좀 대신 써줘
public class Ex19637_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<Power> arr=new ArrayList<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Power(st.nextToken(), Integer.parseInt(st.nextToken())));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int stat=Integer.parseInt(st.nextToken());
            int lt=0;
            int rt=n-1;
            while(lt<=rt) {
                int mid=(lt+rt)/2;
                //어떤 캐릭터의 전투력으로 출력할 수 있는 칭호가 여러 개인 경우 가장 먼저 입력된 칭호 하나만 출력한다.
                //->이 조건 때문에 stat=arr.get(mid).value를 따로 나누면 안됨, 나눠서 stat=arr.get(mid).value 일때 바로 sb.append(arr.get(mid).name)을 해버리면 반례가 생길 수 있음
                if(stat<=arr.get(mid).value) {
                    rt=mid-1;
                } else {
                    lt=mid+1;
                }
            }
            //lt=rt여도 while문을 돌기때문에 최종적으로 rt+1을 해줘야 함 -> 예제 입력1 기준으로 가능한 최소 stat인 0, 가능한 최대 stat인 1000000 따져보면 알 수 있음
            sb.append(arr.get(rt+1).name+"\n");
        }
        System.out.println(sb);
    }
}
