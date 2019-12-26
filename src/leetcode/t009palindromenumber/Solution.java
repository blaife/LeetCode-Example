package leetcode.t009palindromenumber;

/**
 * """""""""""""""""""""""""""""""""""""""""回文数"""""""""""""""""""""""""""""""""""""""""
 *
 * 题意：
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Solution {

    /**
     * 反转一半的数字
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        /**
         * 排除特殊情况
         * 1.负数：一定不会是回文数
         * 2.x > 0 但又以0结尾的数不可能是回文数
         */
        if (x < 0 || (x%10 == 0 && x != 0)) {
            return false;
        }
        // 存储一半数
        int r = 0;
        // r < x 说明未及一般 循环条件
        while (r < x) {
            // r 每次循环添加位数
            r = r*10 + x % 10;
            // x 每次循环删除位数
            x /= 10;
        }
        /**
         * 分为两种情况
         * 1. x 位数为偶数 则 x应等于r
         * 2. x 位数为奇数 则 x应等于r/10 (去除中位数)
         */
        return r == x || x == r/10;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(125848521));
    }
}
