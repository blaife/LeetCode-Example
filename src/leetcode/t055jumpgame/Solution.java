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
    // 逆推找0。
    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == 0) {
                if (i == 0) {
                    return false;
                }
                int num = i - 1;
                while (num >= 0) {
                    if (nums[num] > i-num){
                        break;
                    }
                    if (num == 0) {
                        return false;
                    }
                    num --;
                }
            }
        }
        return true;
    }

    // 更新最远距离
    public boolean canJump2(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k < i) {
                return false;
            }
            k = Math.max(k, i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = new Solution().canJump(new int[]{3,2,1,0,4});
        System.out.println(result);
    }
}
