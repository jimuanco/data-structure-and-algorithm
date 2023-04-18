package Programmers.Lv1;

//둘만의 암호(Lv1)
/*
s	skip	index	result
"aukks"	"wbqd"	5	"happy"
 */
//String contains!!
class Ex07_a {
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        String answer = "";
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            int cnt = 1;
            while(cnt<=index) {
                ++ch;
                if(ch > 'z') {
                    ch-=26;
                }
                if(skip.contains(ch+"")) {
                    continue;
                }
                cnt++;
            }
            answer+=ch;
        }
        System.out.println(answer);
    }
}