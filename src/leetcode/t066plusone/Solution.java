package leetcode.t066plusone;

import java.util.Arrays;

/**
 * """""""""""""""""""""""""""""""加一"""""""""""""""""""""""""""""""
 *
 * 题意：
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Solution {
    /**
     * 情况判断 只有 9 和 不是9 两种情况
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int nums = digits.length;
        for(int i = nums-1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        int[] result = new int[nums+1];
        Arrays.fill(result,0);
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] result = new Solution().plusOne(new int[]{9, 9});
        System.out.println(result);
    }
}
