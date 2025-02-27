package Review.Lecture2025.Recursive_Tree_Graph_DFS_BFS_basic;

// 이진트리순회(DFS)
public class Ex05_a {
    static Node root;
    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        DFS(root);
    }

    private static void DFS(Node root) {
        if (root == null) return;
        else {
            DFS(root.lt);
            DFS(root.rt);
            System.out.print(root.data + " ");
        }
    }

    private static class Node {
        int data;
        Node lt, rt;
        private Node(int val) {
            data = val;
            lt = rt = null;
        }
    }
}
