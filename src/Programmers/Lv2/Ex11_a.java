package Programmers.Lv2;

//2023 KAKAO BLIND RECRUITMENT
//택배 배달과 수거하기(Lv2)

/*
cap	n	deliveries	pickups	result
4	5	[1, 0, 3, 1, 2]	[0, 3, 0, 4, 0]	16
2	7	[1, 0, 2, 0, 1, 0, 2]	[0, 2, 0, 1, 0, 2, 0]	30
 */

class Ex11_a {
    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};
        long answer = 0;
        int delivery = 0;
        int pickup = 0;

        for(int i=n-1; i>=0; i--) {
            delivery += deliveries[i];
            pickup += pickups[i];
            while(delivery > 0 || pickup > 0) {
                delivery -= cap;
                pickup -= cap;
                answer += (i+1) * 2;
            }
        }
        System.out.println(answer);
    }
}
