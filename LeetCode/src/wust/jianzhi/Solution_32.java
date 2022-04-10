package wust.jianzhi;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution_32 {

    @Test
    public int[] levelOrder(TreeNode root) {
        if(root==null)
            return new int[0];
        ArrayList<Integer> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = root;
        queue.add(p);
        while(!queue.isEmpty()){
            p = queue.poll();
            temp.add(p.val);
            if(p.left!=null)
                queue.add(p.left);
            if(p.right!=null)
                queue.add(p.right);
        }
        int[] ends = new int[temp.size()];
        for(int i = 0;i<temp.size();i++){
            ends[i] = temp.get(i);
        }
        return ends;
    }
    @Test
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            //每层数据弹进来，进来之后该层全部弹出后方可结束循环进入下一层
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
    @Test
    public List<List<Integer>> levelOrder3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        int bool = 0;
        if(root!=null)queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            //queue每次都在变，故不能放在判断语句中，得一开始就赋值
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node  =queue.poll();
                temp.add(node.val);
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
            if(bool == 0){
                bool = 1;
            }else{
                for (int i = 0; i < temp.size()/2; i++) {
                    int t = temp.get(i);
                    temp.set(i, temp.get(temp.size()-i-1));
                    temp.set(temp.size()-i-1,t);
                }
                bool =0;
            }
            res.add(temp);
        }
        return res;
    }
}
