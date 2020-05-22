package leetcode.t105constructbinarytreefrompreorderandinordertraversal;

/**
 * @author Blaife
 * @description 105 - 从前序与中序遍历序列构造二叉树
 * @data 2020/5/22 22:18
 * 题意：
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class Solution {
    /**
     * 入口方法
     * @param preorder 前序遍历
     * @param inorder 中序遍历
     * @return Tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 排除一切不合适的情况
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    /**
     * 递归
     * @param preorder 前序遍历
     * @param pStart 前序遍历下标值起点
     * @param pEnd 前序遍历下标值终点
     * @param inorder 中序遍历
     * @param iStart 中序遍历下标值起点
     * @param iEnd 中序遍历下标值起点
     * @return Tree
     */
    private TreeNode help(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        //递归的第一步：递归终止条件，避免死循环
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        //重建根节点
        TreeNode treeNode = new TreeNode(preorder[pStart]);
        //index找到根节点在中序遍历的位置
        int index = 0;
        while (inorder[iStart + index] != preorder[pStart]) {
            index++;
        }
        //重建左子树
        treeNode.left = help(preorder, pStart + 1, pStart + index, inorder, iStart, iStart + index - 1);
        //重建右子树
        treeNode.right = help(preorder, pStart + index + 1, pEnd, inorder, iStart + index + 1, iEnd);
        return treeNode;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
