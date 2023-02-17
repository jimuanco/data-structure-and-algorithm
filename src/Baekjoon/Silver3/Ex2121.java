package Baekjoon.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Coordinate implements Comparable<Coordinate> {
    public int x,y;
    Coordinate(int x, int y) {
        this.x=x;
        this.y=y;
    }
    @Override
    public int compareTo(Coordinate ob) {
        if(this.x==ob.x) return this.y-ob.y;
        else return this.x-ob.x;
    }
}

//넷이 놀기
public class Ex2121 {
    static int n;
    static ArrayList<Coordinate> arr;
    public static boolean binarySearch(int x, int y) {
        int lt=0;
        int rt=n-1;
        boolean flag=false;
        while(lt<=rt) {
            int mid=(lt+rt)/2;
            if(arr.get(mid).x==x && arr.get(mid).y==y) {
                return true;
            }
            if(arr.get(mid).x<x || (arr.get(mid).x==x && arr.get(mid).y<y)) {
                lt=mid+1;
            } else {
                rt=mid-1;
            }
        }
        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            arr.add(new Coordinate(x,y));
        }
        Collections.sort(arr);
        int answer=0;
        for(int i=0; i<n; i++) {
            int c1=arr.get(i).x;
            int c2=arr.get(i).y;
            int cnt=0;
            if(binarySearch(c1,c2+b)) cnt++;
            if(binarySearch(c1+a,c2)) cnt++;
            if(binarySearch(c1+a,c2+b)) cnt++;
            if(cnt==3) answer++;
        }
        System.out.println(answer);
    }
}
