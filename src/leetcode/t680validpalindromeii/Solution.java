package leetcode.t680validpalindromeii;


/**
 * """""""""""""""""""""""""""""""""""""""""""""""""验证回文字符串 Ⅱ"""""""""""""""""""""""""""""""""""""""""""""""""
 * 题意
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 *
 */
public class Solution {
    /**
     * 双指针使用一个参数处理
     * 在遇到第一次不同时进行两方面处理
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int left = 0; // 左指针下标
        left = validIndex(s, left, s.length()-1); // 执行一次双指针验证方法，得到此时的指针位置
        if (2 * left + 1 >= s.length()) { // 通过指针判断是否执行完毕
            return true;
        };
        // 未执行完毕则通过两种情况进行判断，任意一种成功则返回true
        if (validIndex(s, left+1, s.length()-left-1) * 2 >= s.length() || validIndex(s, left, s.length()-left-2) * 2 + 2 >= s.length()) {
            return true;
        };
        return false;
    }

    /**
     * 双指针执行，验证回文
     * @param s 字符串
     * @param left 左指针开始位置
     * @param right 右指针开始位置
     * @return 返回执行结束后左指针位置
     */
    public static Integer validIndex(String s, int left, int right) {
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return left;
    };

    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("abcdcacdba"));
    }
}
