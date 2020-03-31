package leetcode.t912sortanarray;

/**
 * @author Blaife
 * @description 912: 排序数组
 * @data 2020/3/31 15:56
 *
 * 题意：
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 * 提示：
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 */
public class Solution {
    /**
     * 功能描述: 比较排序 - 适用于元素范围很小的情况
     * @author: Blaife
     * @date: 2020/3/31 15:58
     * @param nums 乱序数组
     * @return: int[] 排序后数组
     */
    public int[] sortArray(int[] nums) {
        int max = -50001, min = 50001;
        // 得到最大最小值
        for (int num: nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }

        // 以最大最小值中间的个数创建数组
        int[] counter = new int[max - min + 1];
        // 给指定位置上的值+1
        for (int num: nums) {
            counter[num - min]++;
        }

        int idx = 0;
        // 循环处理的到有顺序的值
        for (int num = min; num <= max; num++) {
            int cnt = counter[num - min];
            while (cnt-- > 0) {
                nums[idx++] = num;
            }
        }
        return nums;
    }
}
