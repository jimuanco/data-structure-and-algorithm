package Programmers.HighScoreKit.DFS_BFS;

//아이템 줍기(Lv3)
/*
rectangle	characterX	characterY	itemX	itemY	result
[[1,1,7,4],[3,2,5,5],[4,3,6,9],[2,6,8,8]]	1	3	7	8	17
[[1,1,8,4],[2,2,4,9],[3,6,9,8],[6,3,7,7]]	9	7	6	1	11
[[1,1,5,7]]	1	1	4	7	9
[[2,1,7,5],[6,4,10,10]]	3	1	7	10	15
[[2,2,5,5],[1,3,6,4],[3,1,4,6]]	1	4	6	3	10
 */
//좌표를 두배 늘려서 해야함 그렇지 않으면 경로를 따라 이동하지 않을 수 있음
import java.util.*;

//class Point {
//    int x, y;
//    Point(int x, int y) {
//        this.x=x;
//        this.y=y;
//    }
//}

class Ex05_wrong {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] graph, distance;

    static void BFS(int x, int y, int itemX, int itemY) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y));
        graph[x][y]=2;
        while(!Q.isEmpty()) {
            Point tmp = Q.poll();
            for(int i=0; i<4; i++) {
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];
                if(nx>=0 && nx<=50 && ny>=0 && ny<=50 && graph[nx][ny]==1) {
                    graph[nx][ny]=2;
                    Q.offer(new Point(nx,ny));
                    distance[nx][ny]=distance[tmp.x][tmp.y]+1;
                    if(nx==itemX && ny==itemY) return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int answer = 0;
        int[][] rectangle= {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX=1;
        int characterY=3;
        int itemX=7;
        int itemY=8;
//        int[][] rectangle = {{1,1,5,7}};
//        int characterX=1;
//        int characterY=1;
//        int itemX=4;
//        int itemY=7;
        graph = new int[51][51];
        distance = new int[51][51];
        for(int i=0; i<rectangle.length; i++) {
            int[] tmp = rectangle[i];
            for(int j=tmp[1]; j<=tmp[3]; j++) {
                for(int k=tmp[0]; k<=tmp[2]; k++) {
                    if(j==tmp[1] || j==tmp[3] || k==tmp[0] || k==tmp[2]) {
                        if(graph[j][k]==-1) continue;
                        graph[j][k]=1;
                    } else {
                        graph[j][k]=-1;
                    }
                }
            }
        }
        BFS(characterY, characterX, itemY, itemX);
        answer=distance[itemY][itemX];
        System.out.println(answer);;
    }
}