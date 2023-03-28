package Programmers.HighScoreKit.Hash;

//베스트앨범(Lv3)
/*
genres	plays	return
["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
 */
import java.util.*;

class Ex05_a {
    public static void main(String[] args) {
        // int[] answer = {};
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        ArrayList<Integer> answer = new ArrayList<>();

        //장르별 재생 횟수 저장
        HashMap<String, Integer> num = new HashMap<>();

        //각 장르에 속한 노래의 <고유번호, 재생 횟수> 저장
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();

        for(int i=0; i<genres.length; i++) {
            if(!num.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
                num.put(genres[i], plays[i]);
            } else {
                music.get(genres[i]).put(i, plays[i]);
                num.put(genres[i], num.get(genres[i])+plays[i]);
            }
        }
        ArrayList<String> keySet = new ArrayList<>(num.keySet());
        Collections.sort(keySet, (s1, s2) -> num.get(s2) - num.get(s1));
        for(String key : keySet) {
            HashMap<Integer, Integer> map = new HashMap<>(music.get(key));
            ArrayList<Integer> uniq_num = new ArrayList<>(map.keySet());

            Collections.sort(uniq_num, (s1, s2) -> map.get(s2) - map.get(s1));

            answer.add(uniq_num.get(0));
            if(uniq_num.size() > 1) {
                answer.add(uniq_num.get(1));
            }
        }

//        answer.stream().mapToInt(i -> i).toArray();
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }
}