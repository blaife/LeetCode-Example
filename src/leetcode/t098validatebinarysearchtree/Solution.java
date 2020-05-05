package leetcode.t098validatebinarysearchtree;

/**
 * @author Blaife
 * @description 098 - 验证二叉搜索树
 * @data 2020/5/5 9:40
 *
 * 题意：
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class Solution {

    /**
     * 可达到的最小值
      */
    long pre = Long.MIN_VALUE;

    /**
     * 中序遍历
     * @param root 树
     * @return 是否为二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {

        // 设置边界方法
        // return isValidBST(root, (long)Integer.MAX_VALUE+1, (long)Integer.MIN_VALUE-1);

        if (root == null) {
            return true;
        }
        // 访问左节点
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }


    /**
     * 设置边界
     * @param root
     * @param max
     * @param min
     * @return
     */
    public boolean isValidBST(TreeNode root, long max, long min){
        if (root == null) {
            return true;
        }
        if (root.val > min && root.val < max) {
            // 左分支
            if (isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println( Integer.MAX_VALUE);
    }
}




class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}