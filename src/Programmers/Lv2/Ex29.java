package Programmers.Lv2;

//Summer/Winter Coding(~2018)
//스킬트리(Lv2)

/*
skill	skill_trees	return
"CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
 */

class Ex29 {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        int answer = 0;
        for(int i=0; i<skill_trees.length; i++) {
            // String str = "";
            StringBuilder sb = new StringBuilder();
            for(char x : skill_trees[i].toCharArray()) {
                if(skill.contains(x+"")) {
                    // str+=x;
                    sb.append(x);
                }
            }
            if(skill.substring(0,sb.toString().length()).equals(sb.toString())) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}