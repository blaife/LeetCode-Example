package leetcode.t102binarytreelevelordertraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Blaife
 * @description 102 - 二叉树的层序遍历
 * @data 2020/5/13 22:12
 * 题意：
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class Solution {

    /**
     * 存储遍历值
     */
    List<List<Integer>> result;

    /**
     * 构造方法 初始化值
     */
    public Solution() {
        this.result = new ArrayList<>();
    }

    /**
     * 主要方法，入口数
     * @param root 二叉树顶节点
     * @return 层序遍历结果
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        recursion(root, 1);
        return result;
    }

    /**
     * 核心递归方法
     * @param thisNode 当前节点
     * @param tier 层级
     */
    public void recursion(TreeNode thisNode, int tier) {

        // 若当前节点为null， 停止执行
        if (thisNode == null) {
            return;
        }

        // 第一次执行这一层的内容， 需要在层序集合中添加当前层的List集合
        if (result.size() < tier) {
            result.add(new ArrayList<>());
        }

        // 放入当前值
        result.get(tier-1).add(thisNode.val);

        // 对左节点执行
        recursion(thisNode.left, tier + 1);
        // 对右节点执行
        recursion(thisNode.right, tier + 1);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}