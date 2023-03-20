package Study;

import java.util.*;


class BitMask{
    //비트를 담는 list.
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        int n = relation.length;
        int m = relation[0].length;

        //조합을 만들어내는 for loop
        for (int i = 1; i < 1 << m; i++) {
            Set<String> set = new HashSet<>();
            //배열의 전체를 도는 for loop
            for(int j = 0; j < n; j++){
                String temp = "";
                //배열의 요소를 도는 for loop
                for(int k = 0; k < m; k++){
                    if((i & 1 << k) > 0){
                        temp += (relation[j][k]);
                    }
                }
                set.add(temp);
            }
            //유일성을 만족하고 최소성을 만족한다면
            if(set.size() == n && check(i)){
                answer.add(i);
            }
        }
        System.out.println(answer.size());
    }
    static boolean check(int i) {
        for (int j : answer) {
            // i & j == j의 의미는 i가 j의 부분집합인지에 대한 여부를 묻는 것.
            if ((i & j) == j) return false;
        }
        return true;
    }
}