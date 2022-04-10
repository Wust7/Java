package wust.jianzhi;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_28 {
//    public TreeNode mirrorTree(TreeNode root){
//        if(root == null)return null;
//        TreeNode node = new TreeNode(root.val);
//        TreeNode temp = root.left;
//        node.left = mirrorTree(root.right);
//        node.right = mirrorTree(temp);
//        return node;
//    }
//    public boolean isSymmetric(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        Queue<TreeNode> mirrorQueue = new LinkedList<>();
//        TreeNode p = mirrorTree(root);
//        if(root!=null)queue.add(root);
//        if(root!=null)mirrorQueue.add(p);
//        while(!queue.isEmpty()){
//            TreeNode node = queue.poll();
//            TreeNode mirrorNode = mirrorQueue.poll();
//            if(node.val!=mirrorNode.val){
//                return false;
//            }
//            if(node.left!=null)queue.add(node.left);
//            if(node.right!=null)queue.add(node.right);
//            if(mirrorNode.left!=null)mirrorQueue.add(mirrorNode.left);
//            if(mirrorNode.right!=null)mirrorQueue.add(mirrorNode.right);
//        }
//        return true;
//    }
public static void main(String[] args) {
    System.out.println(null==null);
}
}
