package Study;

public class lowerBond_upperBond {
    static int lowerBond(int[] arr, int target) {
        int lt=0;
        int rt=arr.length-1;
        while(lt<=rt) {
            int mid=(lt+rt)/2;
            if(arr[mid]>=target) rt=mid-1;
            else lt=mid+1;
        }
        return rt;
    }
    static int upperBond(int[] arr, int target) {
        int lt=0;
        int rt=arr.length-1;
        while(lt<=rt) {
            int mid=(lt+rt)/2;
            if(arr[mid]>target) rt=mid-1;
            else lt=mid+1;
        }
        return rt;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,3,3,5,6,7}; //오름차순 정렬!
        int lower=lowerBond(arr,4); //target이 없으면 target보다 첫번째로 작은 원소의 인덱스 리턴
        int upper=upperBond(arr,4); //target이 없으면 target보다 첫번째로 작은 원소의 인덱스 리턴
        System.out.println(lower); //4
        System.out.println(upper); //4
        int lower2=lowerBond(arr,3); //target이 있으면 target보다 첫번째로 작은 원소의 인덱스 리턴
        int upper2=upperBond(arr,3); //target이 있으면 tartget중 가장 마지막 원소의 인덱스 리턴
        System.out.println(lower2); //1
        System.out.println(upper2); //4
        System.out.println(upper2-lower2); //3
    }
}
