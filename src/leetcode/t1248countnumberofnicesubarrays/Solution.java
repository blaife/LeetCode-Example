package leetcode.t1248countnumberofnicesubarrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Blaife
 * @description 1248 - 统计[优美子数组]
 * @data 2020/4/21 12:36
 * 题意：
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 */
public class Solution {

    /**
     * 功能描述: 将奇数位置存入数组，并对两边可选偶数的数量进行处理，得到所有子数组情况
     * @author: Blaife
     * @date: 2020/4/21 13:07
     * @param nums
     * @param k
     * @return: int
     */
    public int numberOfSubarrays(int[] nums, int k) {
        // 将奇数的下标存入集合
        ArrayList<Integer> oddArr = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                oddArr.add(i);
            }
        }
        // 如果奇数数量不足，则直接停止循环
        if (oddArr.size() < k) {
            return 0;
        }
        int result = 0;
        // 子数组分配，查看两边可放置偶数数量
        for (int i = 0; i <= oddArr.size() - k; i++) {
            int left = 0;
            int right = 0;
            if (i == 0) {
                left = oddArr.get(i) + 1;
            } else {
                left = oddArr.get(i) - oddArr.get(i-1);
            }
            if (i + k == oddArr.size()) {
                right = nums.length - oddArr.get(i + k -1);
            } else {
                right = oddArr.get(i + k) - oddArr.get(i + k - 1);
            }
            result += left * right;
        }
        return result;

    }

    public static void main(String[] args) {
        int result = new Solution().numberOfSubarrays(new int[]{1,1,2,1,1}, 3);
        System.out.println(result);
    }

}
