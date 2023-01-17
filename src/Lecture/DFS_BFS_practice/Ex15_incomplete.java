package Lecture.DFS_BFS_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//피자배달거리(DFS)
public class Ex15_incomplete {

    static ArrayList<ArrayList<Integer>> pi;
    static ArrayList<ArrayList<Integer>> combiPi;
    static ArrayList<Integer> combi;
    static int numPi, numCombiPi=0, m;

    public static void combi(int L, int s) {
        combiPi = new ArrayList<>();
        if(L==m) {
            combiPi.add(new ArrayList<>());
            numCombiPi++;
            for(int x : combi) {
                combiPi.get(numCombiPi).add(x);
            }
        } else {
            for(int i=s; i<=numPi; i++) {
                combi.add(i);
                combi(L+1,i+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][n];
        pi=new ArrayList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
                if(board[i][j]==2) {
                    pi.add(new ArrayList<>());
                    numPi++;
                    pi.get(numPi).add(i);
                    pi.get(numPi).add(j);
                }
            }
        }
        combi(0,1);

    }
}
