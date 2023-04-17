package Programmers.Lv3;

//2019 카카오 개발자 겨울 인턴십
//불량 사용자(Lv3)
/*
user_id	banned_id	result
["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "abc1**"]	2
["frodo", "fradi", "crodo", "abc123", "frodoc"]	["*rodo", "*rodo", "******"]	2
["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "*rodo", "******", "******"]	3
 */

import java.util.*;

class Ex05 {

    static HashSet<HashSet<String>> result = new HashSet<>();

    static void DFS(HashSet<String> set, int L, String[] user_id, String[] banned_id) {
        if(L == banned_id.length) {
            result.add(set);
            return;
        }

        for(int i=0; i<user_id.length; i++) {
            if(set.contains(user_id[i])) {
                continue;
            }

            if(check(user_id[i], banned_id[L])) {
                set.add(user_id[i]);
                DFS(new HashSet<>(set), L+1, user_id, banned_id);
                set.remove(user_id[i]);
            }
        }
    }

    static boolean check(String userId, String bannedId) {
        if(userId.length() != bannedId.length()) {
            return false;
        }

        for(int i=0; i<userId.length(); i++) {
            if(bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        DFS(new HashSet<>(), 0, user_id, banned_id);

        System.out.println(result.size());
    }
}