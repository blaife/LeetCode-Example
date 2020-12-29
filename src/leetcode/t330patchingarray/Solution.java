package leetcode.t330patchingarray;

/**
 * @author Blaife
 * @description 236 - 按要求补齐数组
 * @date 2020/12/29 23:09
 * 题意：
 * 给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。
 *
 * 示例 1:
 * 输入: nums = [1,3], n = 6
 * 输出: 1
 * 解释:
 * 根据 nums 里现有的组合 [1], [3], [1,3]，可以得出 1, 3, 4。
 * 现在如果我们将 2 添加到 nums 中， 组合变为: [1], [2], [3], [1,3], [2,3], [1,2,3]。
 * 其和可以表示数字 1, 2, 3, 4, 5, 6，能够覆盖 [1, 6] 区间里所有的数。
 * 所以我们最少需要添加一个数字。
 *
 * 示例 2:
 * 输入: nums = [1,5,10], n = 20
 * 输出: 2
 * 解释: 我们需要添加 [2, 4]。
 *
 * 示例 3:
 * 输入: nums = [1,2,2], n = 5
 * 输出: 0
 */
public class Solution {
    /**
     * 贪心算法
     *
     * 对于正整数 xx，如果区间 [1,x-1][1,x−1] 内的所有数字都已经被覆盖，
     * 且 xx 在数组中，则区间 [1,2x-1][1,2x−1] 内的所有数字也都被覆盖。
     *
     * 证明如下。
     * 对于任意 1 \le y<x1≤y<x，yy 已经被覆盖，xx 在数组中，因此 y+xy+x 也被覆盖，
     * 区间 [x+1,2x-1][x+1,2x−1]（即区间 [1,x-1][1,x−1] 内的每个数字加上 xx 之后得到的区间）内的所有数字也被覆盖，
     * 由此可得区间 [1,2x-1][1,2x−1] 内的所有数字都被覆盖。
     *
     *
     * @param nums
     * @param n
     * @return
     */
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int length = nums.length, index = 0;
        while (x <= n) {
            if (index < length && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                patches++;
            }
        }
        return patches;
    }
}
