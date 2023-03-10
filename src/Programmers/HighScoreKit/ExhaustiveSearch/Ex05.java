package Programmers.HighScoreKit.ExhaustiveSearch;

//피로도(Lv2)
/*
k	dungeons	result
80	[[80,20],[50,40],[30,10]]	3
 */
class Ex05 {
    int answer = 0;
    int[] visited;
    void DFS(int L, int k, int[][] dungeons) {
        for(int i=0; i<dungeons.length; i++) {
            if(visited[i] == 0 && k >= dungeons[i][0]) {
                visited[i] = 1;
                DFS(L+1, k - dungeons[i][1], dungeons);
                visited[i] = 0;
            }
        }
        answer = Math.max(answer, L);
    }
    public int solution(int k, int[][] dungeons) {
        visited = new int[dungeons.length];
        DFS(0, k, dungeons);
        return answer;
    }
}
