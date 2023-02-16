package Programmers.Lv2;

//타겟 넘버
//깊이/너비 우선 탐색(DFS/BFS)
class Ex02 {
    static int sum=0, ans=0;
    static void DFS(int L, int[] numbers, int target, int sum) {
        if(L==numbers.length) {
            if(sum==target) {
                ans++;
            }
        } else {
            DFS(L+1,numbers,target,sum+numbers[L]);
            DFS(L+1,numbers,target,sum-numbers[L]);
        }
    }
    public static void main(String[] args) {
        int[] numbers={1,1,1,1,1};
        int target=3;
        int answer = 0;
        DFS(0,numbers,target,sum);
        answer=ans;
        System.out.println(answer);
    }
}
