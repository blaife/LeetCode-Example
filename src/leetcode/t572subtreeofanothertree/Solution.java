package leetcode.t572subtreeofanothertree;

/**
 * @author Blaife
 * @description 572 - 另一个树的子树
 * @data 2020/5/7 15:16
 *
 * 题意：
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false。
 */
public class Solution {
    /**
     * 递归算法
     * @param s 树
     * @param t 子树
     * @return 判断是否为子树
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // t 为 null 一定都是 true
        if (t == null) {
            return true;
        }
        // 这里 t 一定不为 null, 只要 s 为 null，肯定是 false
        if (s == null) {
            return false;
        }
        // s向下递归，判断是否为子树
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s,t);
    }

    /**
     * 判断两棵树是否相同
     */
    public boolean isSameTree(TreeNode s, TreeNode t){
        // 当前两树都为null 则相同
        if (s == null && t == null) {
            return true;
        }
        // 当前两数 一树为null 则不相同
        if (s == null || t == null) {
            return false;
        }
        // 两数值不相同，则不相同
        if (s.val != t.val) {
            return false;
        }
        // 两数值相同，则向下递归
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}