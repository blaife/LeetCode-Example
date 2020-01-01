package leetcode.t007reverseinteger;

/**
 * """"""""""""""""""""""""""""""""""""""整数反转""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *  
 * 示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 */
public class Solution {

    public int reverse(int x) {
        int rev = 0; // 返回值
        while (x != 0) { // 从个位开始往高位进发
            int pop = x % 10; // 获取新的pop 当前位数据
            x /= 10; // 数据右进位
            // 数据大于最高值
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            // 数据小于最低值
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            // 处理返回值
            rev = rev * 10 + pop;
        }
        return rev;
    }

}