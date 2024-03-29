package leetcode.t453minimummovestoequalarrayelements;

import java.util.Arrays;

/**
 * @Description: 最小操作次数使数组元素相等
 *
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 * 示例 2：
 * 输入：nums = [1,1,1]
 * 输出：0
 *
 * @Author: magd39318
 * @Date: 2021/10/20 9:43
 */
public class Solution {

    /**
     * 数学解法：每次操作既可以理解为使 n-1 个元素增加 1，也可以理解使 1 个元素减少 1
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }

}
