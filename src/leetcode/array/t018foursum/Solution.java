package leetcode.array.t018foursum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * """""""""""""""""""""""""""四数之和"""""""""""""""""""""""""""
 * 题意：
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意： 答案中不可以包含重复的四元组。
 *
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 思路：先排序，然后使用双层循环固定两个数，然后使用双指针去查找最合适的数
        List<List<Integer>> res = new ArrayList<>(); // 返回的结果
        // 如果长度不够，直接输出
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums); // 排序
        int l = nums.length; // 数组总长度
        int pointer1 = 0; // 指针1
        int pointer2 = 0; // 指针2
        for (int i = 0; i <= l-4; i++){ // 第一层循环
            if (nums[i]*4 > target) {
                return res;
            }
            // 重复的数 跳出本次循环
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for (int j = i+1; j <= l-3; j++){ // 第二层循环
                // 1.重复的数 跳出本次循环 注意:j<i+1, 规避情况nums[i]==ums[j]
                // 2.最大值解法 j后面的一定大于等于j， 全部排除
                if(j > i+1 && nums[j] == nums[j - 1] || nums[i] + nums[j]*3 > target){
                    continue;
                }
                pointer1 = j+1; // 指针一赋值
                pointer2 = l-1; // 指针二赋值
                while (pointer1 < pointer2){
                    int sum = nums[i]+nums[j]+nums[pointer1]+nums[pointer2];
                    if (sum > target){
                        while (pointer1 < pointer2 && nums[pointer2] == nums[--pointer2]);
                    } else if (sum < target) {
                        while (pointer1 < pointer2 && nums[pointer1] == nums[++pointer1]);
                    } else {
                        List<Integer> answer = new ArrayList<>();
                        answer.add(nums[i]);
                        answer.add(nums[j]);
                        answer.add(nums[pointer1]);
                        answer.add(nums[pointer2]);
                        res.add(answer);
                        while (pointer1 < pointer2 && nums[pointer2] == nums[--pointer2]);
                        while (pointer1 < pointer2 && nums[pointer1] == nums[++pointer1]);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> x = new Solution().fourSum(nums, target);
        for (List<Integer> l : x) {
            for (Integer i : l){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
