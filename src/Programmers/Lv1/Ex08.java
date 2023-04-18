package Programmers.Lv1;

//카드 뭉치
/*
cards1	cards2	goal	result
["i", "drink", "water"]	["want", "to"]	["i", "want", "to", "drink", "water"]	"Yes"
["i", "water", "drink"]	["want", "to"]	["i", "want", "to", "drink", "water"]	"No"
 */

class Ex08 {
    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        String answer = "No";

        int p1=0, p2=0, idx=0;

        while(p1<cards1.length && p2<cards2.length && idx<goal.length) {
            if(goal[idx].equals(cards1[p1])) {
                p1++;
                idx++;
            } else if(goal[idx].equals(cards2[p2])) {
                p2++;
                idx++;
            } else {
                System.out.println("No");
                return;
            }
            if(idx==goal.length) {
                System.out.println("Yes");
                return;
            }
        }

        while(p1<cards1.length) {
            if(goal[idx].equals(cards1[p1])) {
                p1++;
                idx++;
            } else {
                System.out.println("No");
                return;
            }
            if(idx==goal.length) {
                System.out.println("Yes");
                return;
            }
        }

        while(p2<cards2.length) {
            if(goal[idx].equals(cards2[p2])) {
                p2++;
                idx++;
            } else {
                System.out.println("No");
                return;
            }
            if(idx==goal.length) {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println(answer);
    }
}
