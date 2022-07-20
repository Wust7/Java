package wust;

import org.junit.Test;
import wust.jianzhi.TreeNode;

import java.util.*;

public class Solution_test17 {
    public ArrayList<TreeNode> dele(TreeNode root, ArrayList<Integer> a){
        int count = 1;
        TreeNode p = root;
        //获得每一层节点
        Map<Integer,List<TreeNode>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> level = new ArrayList<TreeNode>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            map.put(count,level);
            count++;
        }
        //删除上下层连接关系
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i)!=1){
                List<TreeNode> levelmap = map.get(a.get(i) - 1);
                for (TreeNode treeNode : levelmap) {
                    treeNode.left =null;
                    treeNode.right =null;
                }
            }
        }
        //
        ArrayList<TreeNode> res = new ArrayList<>();
        if(!a.contains(1)){
            res.addAll(map.get(1));
        }
        for (int i = 1; i < map.size()-1; i++) {
            if(a.contains(i+1)){
                res.addAll(map.get(i + 2));
            }
        }
        return res;
    }
}
