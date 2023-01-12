package Lecture.Recursive_Tree_Graph_DFS_BFS_basic;

import java.util.LinkedList;
import java.util.Queue;

//Tree 말단노드까지의 까장 짧은 경로(BFS)
public class Ex10 {
    Node root;
    public int BFS(int L, Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) {
                Node cur = Q.poll();
                if(cur.lt==null && cur.rt==null) return L;
                if(cur.lt!=null) Q.offer(cur.lt);
                if(cur.rt!=null) Q.offer(cur.rt);
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Ex10 tree = new Ex10();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        System.out.println(tree.BFS(0, tree.root));
    }
}
