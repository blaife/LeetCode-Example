package leetcode.t045jumpgameii;

/**
 * """""""""""""""""""""""""""""""""""""""跳跃游戏 II"""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * 假设你总是可以到达数组的最后一个位置。
 */
public class Solution {
    /**
     * 贪心算法 寻找最远位置
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    /**
     * 顺藤摸瓜 倒序查找
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int position = nums.length - 1; //要找的位置
        int steps = 0;
        while (position != 0) { //是否到了第 0 个位置
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) { // 说明可以到达
                    position = i; //更新要找的位置
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int result = new Solution().jump(new int[]{2, 3, 1, 1, 1});
        System.out.println(result);
    }
}
