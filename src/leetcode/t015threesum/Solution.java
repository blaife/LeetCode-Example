package leetcode.t015threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * """"""""""""""""""""""""""""""三数之和""""""""""""""""""""""""""""""
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // 对数组进行排序
        List<List<Integer>> res = new ArrayList<>();
        // 从第一个元素开始
        for(int k = 0; k < nums.length - 2; k++){
            // 大于0的数相加都为正数，跳出循环
            if(nums[k] > 0) {
                break;
            }
            // 重复的数 跳出本次循环
            if(k > 0 && nums[k] == nums[k - 1]){
                continue;
            }
            // i为当前循环元素的下一个元素  j为最后一个元素
            int i = k + 1, j = nums.length - 1;
            // i与j之间还有数据
            while(i < j){
                // 获取三数之和
                int sum = nums[k] + nums[i] + nums[j];
                // 如果和小于0 i+1
                // 如果和大于0 j-1
                // 如果和等于0 i+1 j-1
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
