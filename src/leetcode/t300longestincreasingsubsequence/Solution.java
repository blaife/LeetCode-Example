package leetcode.t300longestincreasingsubsequence;

/**
 * """"""""""""""""""""""""""""""""""""""""""""""最长上升子序列""""""""""""""""""""""""""""""""""""""""""""""
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class Solution {

    /**

     ''''''''''''''''''''''''贪心 + 二分查找'''''''''''''''''''''''''''

     dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
     由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
     对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
     1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
     数组尾部, 并将最长递增序列长度maxL加1
     2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
     **/
    public int lengthOfLIS_difficult(int[] nums) {
        int maxL = 0; // 最大长度
        int[] dp = new int[nums.length]; // 记录上升子序列的集合
        for(int num : nums) {
            // 二分法查找, 也可以调用库函数如binary_search
            // hi 最大长度
            int lo = 0, hi = maxL;
            // 二分查找，最终得到一个大于当前值，但前一位
            while(lo < hi) {
                // 中间值的位置
                int mid = lo+(hi-lo)/2;
                // 如果指定位置的值小于当前判断的值 再对后半段二分查找
                if(dp[mid] < num) {
                    lo = mid+1;
                } else { // 否则对前半段二分查找
                    hi = mid;
                }
            }
            dp[lo] = num;
            if(lo == maxL)
                maxL++;
        }
        return maxL;
    }




    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS_difficult(new int[]{9, 10, 11, 5, 8, 9}));
    }

}
