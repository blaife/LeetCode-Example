package leetcode.t606constructstringfrombinarytree;

import java.util.Objects;

/**
 * """""""""""""""""""""""""""""""""""""""""""""根据二叉树创建字符串"""""""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 示例 1:
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 *
 * 示例 2:
 * 输入: 二叉树: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * 输出: "1(2()(4))(3)"
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    /**
     * 递归算法
     * @param t
     * @return
     */
    public static String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        // 得到左节点值
        String left = tree2str(t.left);
        // 得到右节点值
        String right = tree2str(t.right);
        if (left == "" && right == "") {
            return t.val+"";
        }
        return right == "" ? t.val + "(" + left + ")" : t.val+"(" + left + ")(" + right + ")" ;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.right = new TreeNode(4);
        System.out.println(tree2str(t));
    }

}
