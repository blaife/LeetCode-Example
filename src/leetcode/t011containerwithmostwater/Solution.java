package leetcode.t011containerwithmostwater;

/**
 * """"""""""""""""""""盛最多水的容器""""""""""""""""""""
 * 题意：
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class Solution {
    /**
     * 使用双指针，一次循环。消除不可能为最大值的参数
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int area = 0;
        while (i < j){
            area = Math.max(area, Math.max(height[i], height[j]) * (j-i));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,3,5,6,3,4,4,5,7,8};
        new Solution().maxArea(height);
    }
}
