package Study;

//비트마스킹으로 부분집합 구하기
public class SubSetByBitMask {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int n = arr.length;

        System.out.println(1 << n);

        for(int i=1; i<(1<<n); i++) {
            for(int j=0; j<n; j++) {
                if((i & (1<<j)) > 0) {
                    System.out.print(arr[j]+", ");
                }
            }
            System.out.println();
        }
    }
}
