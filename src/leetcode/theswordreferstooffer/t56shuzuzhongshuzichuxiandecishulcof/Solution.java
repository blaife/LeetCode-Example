package leetcode.theswordreferstooffer.t56shuzuzhongshuzichuxiandecishulcof;

import java.util.Arrays;

/**
 * @author Blaife
 * @description 面试题 56 - 1 数组中数字出现的次数
 * @data 2020/4/28 15:41
 * 题意：
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 *
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *  
 * 限制：
 * 2 <= nums <= 10000
 */
public class Solution {
    /**
     * 排序后判断当前值的前后位
     * @param nums 原数组
     * @return 出现一次的数字
     */
    public int[] singleNumbers(int[] nums) {
        int[] result = new int[2];
        // result的下标
        int index = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 判断前后位置
            if ((i == 0 || nums[i] != nums[i - 1]) && (i == nums.length - 1 || nums[i] != nums[i + 1])) {
                result[index] = nums[i];
                index ++;
            }
            // 之后两个数量为1的数字
            if (index > 1) {
                break;
            }
        }
        return result;
    }
}
