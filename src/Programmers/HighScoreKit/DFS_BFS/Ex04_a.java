package Programmers.HighScoreKit.DFS_BFS;

//단어 변환(Lv3)
/*
begin	target	words	return
"hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
"hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	0
 */
class Ex04_a {
    int[] visited;
    int answer = 0;
    void recur(String word, String target, String[] words, int cnt) {
        if(word.equals(target)) {
            answer = cnt;
            return;
        }
        for(int i=0; i< words.length; i++) {
            if(visited[i]==1) {
                continue;
            }
            int num=0;
            for(int j=0; j<words[i].length(); j++) {
                if(word.charAt(j) == words[i].charAt(j)) {
                    num++;
                }
            }
            if(word.length() - 1 == num) {
                visited[i]=1;
                recur(words[i], target, words, cnt+1);
                visited[i]=0;
            }
        }
    }
    public int solution(String begin, String target, String[] words) {
        visited = new int[words.length];
        int cnt = 0;
        recur(begin, target, words, 0);
        return answer;
    }
}