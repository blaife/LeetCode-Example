package leetcode.t055jumpgame;

/**
 * """"""""""""""""""""""""""""""""跳跃游戏""""""""""""""""""""""""""""""""
 *
 * 题意：
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class Solution {
    /**
     * 功能描述: 逆推找0。
     * @author: Blaife
     * @date: 2020/4/17 13:48
     * @param nums 跳跃数组
     * @return: boolean
     */
    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            // 找到为0的位置
            if (nums[i] == 0) {
                // 第一个为0， 则一定false
                if (i == 0) {
                    return false;
                }
                // 找到前一位
                int num = i - 1;
                // 一直向前递进
                while (num >= 0) {
                    // 成立则说明能跳过这个为0的位置
                    if (nums[num] > i-num){
                        break;
                    }
                    // 一直递推到0 的位置都无法跳过这个位置，则说明永远都无法到达最后一个位置
                    if (num == 0) {
                        return false;
                    }
                    num --;
                }
            }
        }
        return true;
    }

    /**
     * 功能描述: 更新最远距离
     * @author: Blaife
     * @date: 2020/4/17 13:49
     * @param nums 跳跃数组
     * @return: boolean
     */
    public boolean canJump2(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当前所能跳到的最大位置大于当前位置的下标， 则一定能到达这个位置
            if (k < i) {
                return false;
            }
            // 更新最远的距离 为 K值 与 到达i位置再跳最大距离 的比较
            k = Math.max(k, i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = new Solution().canJump(new int[]{3,2,1,0,4});
        System.out.println(result);
    }
}
