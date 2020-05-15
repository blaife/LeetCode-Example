package leetcode.t560subarraysumequalsk;

import java.util.HashMap;

/**
 * @author Blaife
 * @description 560 - 和为k的子数组
 * @data 2020/5/15 13:33
 * 题意：
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class Solution {

    /**
     * 前缀和 + 哈希表优化
     *
     * 那么「[j..i][j..i] 这个子数组和为 kk 」这个条件我们可以转化为： pre[i]−pre[j−1]==k
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums 数组
     * @param k 和
     * @return 适配的子数组数量
     */
    public int subarraySum(int[] nums, int k) {
        // count: 数量   pre: 和
        int count = 0, pre = 0;
        // 存储   每个位置时的和，当前数量
        HashMap <Integer, Integer > mp = new HashMap< >();
        // ？？？
        mp.put(0, 1);
        // 循环数组
        for (int i = 0; i < nums.length; i++) {
            // 当前位之前的所有数的和
            pre += nums[i];
            // 如果当前总和 减去某一位的数字为目标值 则数量添加
            if (mp.containsKey(pre - k)) {
                // 数量添加
                count += mp.get(pre - k);
            }
            // 如果当前map中存储这个数量的话， 则这个值+1，默认为1
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[]{-1, -1 ,1}, 0));
    }

}
