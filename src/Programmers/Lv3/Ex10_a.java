package Programmers.Lv3;

//2023 KAKAO BLIND RECRUITMENT
//표현 가능한 이진트리(Lv3)

/*
numbers	result
[7, 42, 5]	[1, 1, 0]
[63, 111, 95]	[1, 1, 0]
 */

class Ex10_a {
    public static void main(String[] args) {
        long[] numbers = {7, 42, 5};
        int[] answer = new int[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            String binaryTree = getBinaryTree(numbers[i]);
            if(checkTree(binaryTree)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }

    // 이진수 변환작업, 이진수의 길이가 포화트리보다 작다면 숫자를 변형시키지 않도록 앞에만 0을 붙인다
    static String getBinaryTree(long number) {
        String binary = Long.toBinaryString(number);
        int height = (int) Math.ceil(Math.log10(binary.length()+1) / Math.log10(2));
        int size = (int) Math.pow(2,height) - 1;

        int dummy = size - binary.length();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<dummy; i++) {
            sb.append("0");
        }

        sb.append(binary);
        return sb.toString();
    }

    //더미노드는 1인 자식을 가질 수 없다
    static boolean checkTree(String binaryTree) {
        if(binaryTree.length() <= 1) {
            return true;
        }

        String leftTree = binaryTree.substring(0,binaryTree.length() / 2);
        String rightTree = binaryTree.substring(binaryTree.length() / 2 + 1);

        char root = binaryTree.charAt(binaryTree.length() / 2);
        char left = leftTree.charAt(leftTree.length() / 2);
        char right = rightTree.charAt(rightTree.length() / 2);

        if(root == '0' && (left == '1' || right == '1')) {
            return false;
        } else {
            return checkTree(leftTree) && checkTree(rightTree);
        }
    }
}

//출처 : https://chamggae.tistory.com/197