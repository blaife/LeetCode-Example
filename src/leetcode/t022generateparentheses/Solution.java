package leetcode.t022generateparentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * """"""""""""""""""""""""""""""""""""""""""""""""""""括号生成""""""""""""""""""""""""""""""""""""""""""""""""""""
 *  给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 *
 * @author Blaife
 */
public class Solution {
    /*
     * 这种找所有可能情况的题一般来说都是递归，需要找到切入点(关键条件)
     * 回溯应该说是递归的扩展了，在每次递归后除此次痕迹时回溯和递归的差异点
     */

    /**
     * 功能描述: 最终结果的存放位置
     */
    private static List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        // 初始化值（在leetcode测试时发现会携带上次运算的值）
        result = new ArrayList<>();
        recallMethod(new StringBuffer(), n, 0, 0);
        return result;
    }

    /**
     * 回溯方法
     * @param s 当前字符串
     * @param n 对数
     * @param left // 左括号数
     * @param right // 右括号数
     * @return
     */
    public static void recallMethod(StringBuffer s, int n, int left, int right) {
        // 最大值时 加入返回值中
        if (left+right == n+n) {
            result.add(s.toString());
        }
        // 此种情况 则可添加 '（'
        if (left < n) {
            s.append('(');
            // 递归
            recallMethod(s, n, left+1, right);
            // 执行完毕后要将此次添加的值去除
            s.delete(s.length()-1, s.length());
        }
        // 此种情况 则可添加 ')'
        if (right < left) {
            s.append(')');
            // 递归
            recallMethod(s, n, left, right+1);
            // 执行完毕后要将此次添加的值去除
            s.delete(s.length()-1, s.length());
        }
    }

    public static void main(String[] args) {
        new Solution().generateParenthesis(1);
        System.out.println(result);
    }
}
