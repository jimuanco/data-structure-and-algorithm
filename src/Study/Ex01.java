package Study;

public class Ex01 {
    public static void main(String[] args) {
        int n = 6;
        int k = 2;
        int[] h = {1, 3, 5, 4, 2, 6};
//        int n = 9;
//        int k = 2;
//        int[] h = {9, 5, 3, 8, 7, 6, 4, 2, 1};
        int idx=0, answer=0;
        for(int i=0; i<h.length;) {
            int tmp = i, max = 0;
            while(i<h.length && i<=tmp+k) {
                if(h[i]>max) {
                    max=h[i];
                    idx = i;
                }
                i++;
            }
            answer++;
            i = idx+k+1;
        }
        System.out.println(answer);
    }
}
