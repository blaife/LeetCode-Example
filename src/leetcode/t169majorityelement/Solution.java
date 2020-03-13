package leetcode.t169majorityelement;

import java.util.Arrays;

/**
 * """"""""""""""""""""""""""""""""""""""""""""""""""""多数元素""""""""""""""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 注意： 非空且一定存在多数元素
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 */
public class Solution {

    /**
     * 排序后取中位数
     * 一个值的数量大于百分之50，则排序后这个值一定覆盖中位数
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * 摩尔投票法 -- 基于一定存在众数的情况，若不存在众数则结果就没有意义了
     * 遇到相同的数，就投一票，遇到不同的数，就减一票，最后还存在票的数就是众数
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int count = 0, result = -1;
        for (int n : nums) {
            if (count == 0) {
                result = n;
            }
            if (n == result) {
                ++count;
            } else {
                --count;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement2(new int[]{1,1,3,4,2,2,5,1}));
    }
}
