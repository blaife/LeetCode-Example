package leetcode.t543diameterofbinarytree;

/**
 * """"""""""""""""""""""""""""""""""""""""""""""二叉树的直径""""""""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {

    int diameter = 0;

    /**
     * 递归算法
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }
        getMaxDep(root);
        return diameter;
    }

    /**
     * 获取对当前节点左右两条边的最大长度
     * @param curNode
     * @return
     */
    public int getMaxDep (TreeNode curNode) {
        if (curNode == null) {
            return 0;
        }
        int leftDep = getMaxDep(curNode.left);
        int rightDep = getMaxDep(curNode.right);

        /**
         * 获取以当前节点为顶节点 可以得到的最大长度
         */
        if ((leftDep+rightDep) > diameter) {
            diameter = leftDep + rightDep;
        }
        // 返回左右两边的最大长度+1，即加上自身节点
        return Math.max(leftDep, rightDep) + 1;
    }
}
