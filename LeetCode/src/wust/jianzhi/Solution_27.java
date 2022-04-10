package wust.jianzhi;

import java.util.LinkedList;
import java.util.Queue;


public class Solution_27 {
    //递归的神
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}
