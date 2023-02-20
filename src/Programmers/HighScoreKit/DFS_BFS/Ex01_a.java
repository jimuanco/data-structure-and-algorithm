package Programmers.HighScoreKit.DFS_BFS;

//타겟 넘버(Lv2)
/*
numbers	target	return
[1, 1, 1, 1, 1]	3	5
[4, 1, 2, 1]	4	2
 */
class Ex01_a {
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
        System.out.println(answer);;
    }
}