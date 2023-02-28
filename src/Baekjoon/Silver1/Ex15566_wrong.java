package Baekjoon.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//개구리 1
//90%에서 틀림
public class Ex15566_wrong {
    static int n, m;
    static int[] Lotus;
    static int[][] preference,subject,tree;
    static void recur(int L) {
        if(L>n) {
            int cnt=0;
            for(int i=0; i<m; i++) {
                int num1=tree[i][0];
                int num2=tree[i][1];
                int talk=tree[i][2];
                int frog1=Lotus[num1];
                int frog2=Lotus[num2];
                if(subject[frog1][talk-1]==subject[frog2][talk-1]) {
                    cnt++;
                }
                if(cnt==n) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("YES"+"\n");
                    for(int j=1; j<=n; j++) {
                        sb.append(Lotus[j]+" ");
                    }
                    System.out.println(sb);
                    System.exit(0);
                }
            }
        } else {
            for(int i=0; i<2; i++) {
                if(Lotus[preference[L][i]]==0) {
                    Lotus[preference[L][i]]=L;
                    recur(L+1);
                    Lotus[preference[L][i]]=0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        subject = new int[n+1][4];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            subject[i][0] = Integer.parseInt(st.nextToken());
            subject[i][1] = Integer.parseInt(st.nextToken());
            subject[i][2] = Integer.parseInt(st.nextToken());
            subject[i][3] = Integer.parseInt(st.nextToken());
        }
        preference = new int[n+1][2];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            preference[i][0]=Integer.parseInt(st.nextToken());
            preference[i][1]=Integer.parseInt(st.nextToken());
        }
        tree = new int[m][3];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            tree[i][0] = Integer.parseInt(st.nextToken());
            tree[i][1] = Integer.parseInt(st.nextToken());
            tree[i][2] = Integer.parseInt(st.nextToken());
        }
        Lotus = new int[n+1];
        recur(1);
        System.out.println("NO");
    }
}
