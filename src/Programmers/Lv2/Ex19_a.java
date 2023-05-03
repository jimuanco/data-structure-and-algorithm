package Programmers.Lv2;

//2019 카카오 개발자 겨울 인턴십
//튜플(Lv2)

/*
s	result
"{{2},{2,1},{2,1,3},{2,1,3,4}}"	[2, 1, 3, 4]
"{{1,2,3},{2,1},{1,2,4,3},{2}}"	[2, 1, 3, 4]
"{{20,111},{111}}"	[111, 20]
"{{123}}"	[123]
"{{4,2,3},{3},{2,3,4,1},{2,3}}"	[3, 2, 4, 1]
 */

import java.util.*;

class Ex19_a {
    public static void main(String[] args) {
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        int[] answer = {};
        s = s.substring(2,s.length()-2);
        String[] strings = s.split("},\\{");

        Arrays.sort(strings, (o1, o2) -> (o1.length() - o2.length()));

        List<Integer> arr = new ArrayList<>();
        for(String x : strings) {
            String[] tmp = x.split(",");
            for(int i=0; i<tmp.length; i++) {
                int n = Integer.parseInt(tmp[i]);
                if(!arr.contains(n)) {
                    arr.add(n);
                }
            }
        }
        answer = arr.stream().mapToInt(Integer::intValue).toArray();
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }
}
