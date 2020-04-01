package leetcode.t1111maximumnestingdepthoftwovalidparenthesesstrings;

import java.util.Arrays;

/**
 * @author Blaife
 * @description 1111 - 有效括号的嵌套深度
 * @data 2020/4/1 8:03
 * 题意：
 * 有效括号字符串 仅由 "(" 和 ")" 构成，并符合下述几个条件之一：
 * 空字符串
 * 连接，可以记作 AB（A 与 B 连接），其中 A 和 B 都是有效括号字符串
 * 嵌套，可以记作 (A)，其中 A 是有效括号字符串
 * 类似地，我们可以定义任意有效括号字符串 s 的 嵌套深度 depth(S)：
 * s 为空时，depth("") = 0
 * s 为 A 与 B 连接时，depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是有效括号字符串
 * s 为嵌套情况，depth("(" + A + ")") = 1 + depth(A)，其中 A 是有效括号字符串
 * 例如：""，"()()"，和 "()(()())" 都是有效括号字符串，嵌套深度分别为 0，1，2，而 ")(" 和 "(()" 都不是有效括号字符串。
 *
 * 示例 1：
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 *
 * 示例 2：
 * 输入：seq = "()(())()"
 * 输出：[0,0,0,1,1,0,1,1]
 *
 */
public class Solution {
    /**
     * 功能描述: 获得嵌套深度（循环 - 奇偶分配）
     * @author: Blaife
     * @date: 2020/4/1 8:04
     * @param seq 括号字符串
     * @return: int[]
     */
    public int[] maxDepthAfterSplit(String seq) {
        int[] arr = new int[seq.length()];
        int idx = 0;
        for (char c : seq.toCharArray()) {
            arr[idx++] = c == '(' ?  idx & 1 : ((idx + 1) & 1);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxDepthAfterSplit("(()()()())")));
    }
}
