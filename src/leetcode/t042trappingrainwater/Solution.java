package leetcode.t042trappingrainwater;

/**
 * """"""""""""""""""""""""""""""""接雨水""""""""""""""""""""""""""""""""
 * 题意：
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *  |
 *  |
 *  |       ■
 *  |   ■***■■*■
 *  | ■*■■*■■■■■■
 *  |———————————————————— 将就着看吧
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）
 *
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Solution {
    /**
     * 双指针求解
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // 加右指针进去
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int x = new Solution().trap(new int[]{1, 3, 4, 5, 2, 6, 2, 1, 5, 2, 5, 2, 1});
        System.out.println(x);
    }
}
