package leetcode.t084largestrectangleinhistogram;

import java.util.Stack;

/**
 * """""""""""""""""""""""""""""""""柱状图中最大的矩形"""""""""""""""""""""""""""""""""
 * 题意：给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *         □
 *        □□
 *        □□
 *        □□ □
 *      □ □□□□
 *      □□□□□□
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *        □
 *        □□
 *        □□
 *        □□ □
 *      □ □□□□
 *      □□□□□□
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *  
 *
 * 示例:
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 */
public class Solution {
    /**
     * 解题思路：
     * 如：[2,1,5,6,2,3]
     * 堆栈内容变化为   ①-1 --> ②-1,0 --> ③-1,1 --> ④-1,1,2,3 --> ⑤-1,1,4 --> ⑥-1,1,4,5
     * 在后值小于前值时将前值弹出计算面积
     * ①：此时刚push -1
     * ②：循环一次将下标1的放入
     * ③：循环到1 发现下表1的小于下表0的
     *      开始计算面积 heights[0]*(1-(-1)-1) == 2;
     *      同时弹出tranks的顶部元素 然后把1放入堆栈
     * ④：循环到3 将 2和3 放入堆栈
     * ⑤：循环到4 发现下标4的小于下表3的 开始计算面积
     *      heights[3]*(4-2-1) = 6 * 1 = 6; 同时弹出tranks的顶部元素
     *    移除3之后发现下标4的小于下表2的 开始计算面积
     *      heights[2]*(4-1-1) = 5 * 2 = 10; 同时弹出tranks的顶部元素
     *    移除2之后 下标4的并不小于下标1的 把下标4 放入堆栈
     * ⑥：循环到5 将5 放入堆栈
     *
     * 现在tranks为 [-1,1,4,5]
     * 再次计算面积：
     *      heights[5]*(6-4-1) = 3 * 1 = 3;
     *      heights[4]*(6-1-1) = 2 * 4 = 3;
     *      heights[1]*(6-(-1)-1) = 1 * 6 = 6;
     *
     * 得出：最大值为 10
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        // 栈
        Stack<Integer> stack = new Stack<>();
        // 输入初始值 用与判断结尾 重要的是对于最大值的判断
        stack.push(-1);
        int maxarea = 0; // 最大值
        for (int i = 0; i < heights.length; ++i) {
            // peek 获取栈顶元素 pop 栈顶元素出栈
            // 如果后值小于前值  取出现在指针到达位置前值的面积
            // 从最大值判断
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        // 从最小值判断
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return maxarea;
    }

    public static void main(String[] args) {
        new Solution().largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
}
