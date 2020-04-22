package leetcode.t199binarytreerightsideview;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Blaife
 * @description 199 -
 * @data 2020/4/22 11:34
 * 题意：
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class Solution {

    /** 
     * 功能描述: 层序遍历
     * @author: Blaife
     * @date: 2020/4/22 11:37
     * @param root 二叉树数据
     * @return: java.util.List<java.lang.Integer>
     */
    public List<Integer> rightSideView(TreeNode root) {
        // cnt:当前层级节点数 tmp:当前层级要显示的数据
        int cnt=0,tmp=0;
        // 存储当前处理node的数据节点
        TreeNode node;
        // 返回值
        List<Integer> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        // Queue队列，保持从左到右的次序
        Queue<TreeNode> queue=new LinkedList<>();
        // 将顶点存入
        queue.add(root);
        while(!queue.isEmpty()){
            // 确定层级节点数，即每一层一次循环
            cnt=queue.size();
            while(cnt>0){
                // 得到当前节点
                node=queue.poll();
                // 左节点存入
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                // 右节点存入
                if(node.right!=null) {
                    queue.offer(node.right);
                }
                // 节点--
                cnt--;
                // 当前节点值 while循环完成后，即tmp为最右的那个数据
                tmp=node.val;
            }
            // 将每层最右侧的值存入 res
            res.add(tmp);
        }
        return res;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
