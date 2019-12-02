package leetcode.t078subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * """"""""""""""""""""""""""""""""""""""""子集""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    public void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> temp) {
        res.add(temp);
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);
            backtrack(j+1, nums, res, temp);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> result = new Solution().subsets(new int[]{1, 2, 3});
        System.out.println(result);
    }
}
