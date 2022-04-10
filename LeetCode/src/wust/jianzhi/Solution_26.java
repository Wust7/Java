package wust.jianzhi;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //树中可以有相同值
        //判断B的root
        if(A==null||B==null)return false;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p=null;
        queue.add(A);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.val== B.val){
                Queue<TreeNode> Queue_A = new LinkedList<>();
                Queue<TreeNode> Queue_B = new LinkedList<>();
                Queue_A.add(node);
                Queue_B.add(B);
                while(!Queue_A.isEmpty()){
                    TreeNode node_A = Queue_A.poll();
                    TreeNode node_B = Queue_B.poll();
                    if(node_B==null||node_A.val!=node_B.val)
                        break;
                    if(node_A.left!=null)Queue_A.add(node_A.left);
                    if(node_A.right!=null)Queue_A.add(node_A.right);
                    if(node_B.left!=null)Queue_B.add(node_B.left);
                    if(node_B.right!=null)Queue_B.add(node_B.right);
                    if(Queue_B.isEmpty()){
                        return true;
                    }
                }
            }
            if(node.left!=null)queue.add(node.left);
            if(node.right!=null)queue.add(node.right);
        }

        return false;
    }
}
