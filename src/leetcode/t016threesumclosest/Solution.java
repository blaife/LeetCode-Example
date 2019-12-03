package leetcode.t016threesumclosest;

import java.util.Arrays;

/**
 * """"""""""""""""""""""""""""""""最接近的三数之和""""""""""""""""""""""""""""""""
 * 题意：
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 对数组进行排序
        Arrays.sort(nums);
        int result = 0;
        Integer poor = null;
        // 从第一个元素开始
        for(int k = 0; k < nums.length - 2; k++){
            // i为当前循环元素的下一个元素  j为最后一个元素
            int i = k + 1, j = nums.length - 1;
            // i与j之间还有数据
            while(i < j){
                // 获取三数之和
                int sum = nums[k] + nums[i] + nums[j];
                // 判断差值是多少，根据差值来决定是否要更新返回值
                int poor2 = Math.abs(sum-target);
                if (poor == null ||  poor2 < poor){
                    poor = poor2;
                    result = sum;
                }
                // 如果和小于target i+1
                // 如果和大于target j-1
                if(sum < target){
                    while(i < j && nums[i] == nums[++i]);
                } else {
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int res = new Solution().threeSumClosest(new int[]{-1,2,1,-4}, 1);
        System.out.println(res);
    }
}
