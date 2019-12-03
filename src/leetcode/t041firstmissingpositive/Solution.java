package leetcode.t041firstmissingpositive;

import java.util.Arrays;

/**
 * """"""""""""""""""""""""""""""""缺失的第一个正数""""""""""""""""""""""""""""""""
 * 题意：
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 *
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明: 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class Solution {
    /**
     * 单次循环处理 排除特殊情况 排序后循环处理
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 1) {
                if (i == 0) {
                    return 1;
                }
                if (nums[i] - 1 != nums[i-1] && nums[i] != nums[i-1]){
                    if (nums[i-1] < 1){
                        return 1;
                    } else {
                        return ++nums[i-1];
                    }
                }
            }
        }
        if (nums[nums.length-1] <= 0) {
            return 1;
        } else {
            return ++nums[nums.length-1];
        }
    }


    public static void main(String[] args) {
        int x = new Solution().firstMissingPositive(new int[]{3,4,-1,1});
        System.out.println(x);
    }
}
