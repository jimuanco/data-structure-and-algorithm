package Programmers.Lv2;

//2019 KAKAO BLIND RECRUITMENT
//오픈채팅방
/*
record	result
["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]	["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
 */
import java.util.*;

class Ex03 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] answer = {};
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<record.length; i++) {
            String action = record[i].split(" ")[0];
            String id = record[i].split(" ")[1];
            if(!action.equals("Leave")) {
                String nick = record[i].split(" ")[2];
                map.put(id,nick);
            }
            if(action.equals("Enter") || action.equals("Leave")) {
                arr.add(action+id);
            }
        }
        answer = new String[arr.size()];
        for(int i=0; i<arr.size(); i++) {
            if(arr.get(i).substring(0,5).equals("Enter")) {
                answer[i] = map.get(arr.get(i).substring(5)) + "님이 들어왔습니다.";
            } else {
                answer[i] = map.get(arr.get(i).substring(5)) + "님이 나갔습니다.";
            }
        }
        for(String str : answer) {
            System.out.println(str);
        }
    }
}