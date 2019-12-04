package leetcode.t085maximalrectangle;

import java.util.Arrays;

/**
 * """"""""""""""""""""""""""""""""""""""""""""最大矩形""""""""""""""""""""""""""""""""""""""""""""
 * 题意：
 *  给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 */
public class Solution {
    /**
     * 思路： 动态规划 -- 比较耗时
     * 1.判断当前点是否为0，若为0 不判断
     * 2.若为1，则向上判断获取最大高度
     * 3.获取到最大高度后，左右延申获取最大宽度
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    int height = 1;
                    int maxWidth = 1;
                    // 向上取最大高度
                    while (i-height >= 0 && matrix[i-height][j] == '1') {
                        height ++;
                    }
                    int maxleft = -1;
                    int maxRight = -1;
                    for (int m = 0; m < height; m++) {
                        int left = j;
                        int right = j;
                        while (left > 0 && (maxleft == -1 || maxleft > j - left)) {
                            if (matrix[i-m][left-1] == '1') {
                                left--;
                            } else {
                                break;
                            }
                        }
                        maxleft = Math.max(j-left, 0);
                        while (right < matrix[i].length-1 && (maxRight == -1 || maxRight > right - j)) {
                            if (matrix[i-m][right+1] == '1') {
                                right++;
                            } else {
                                break;
                            }
                        }
                        maxRight = Math.max(right - j, 0);
                        maxleft = Math.min(maxleft, j-left);
                        maxRight = Math.min(maxRight, right-j);

                    }
                    max = Math.max(max, (maxleft+maxRight+1) * height);
                }
            }
        }
        return max;
    }


    /**
     * 动态规划 - 每个点的最大高度
     * 改进版  将每一列的高度都存储起来
     * @param matrix
     * @return
     */
    public int maximalRectangle2(char[][] matrix) {
        if (matrix.length == 0) return 0; // 排除数组长度为0的情况

        // 获取数组长度
        int m = matrix.length;
        int n = matrix[0].length;

        // 将左边初始化为最左边的边界
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];

        // 将右边初始化为最右边的边界
        Arrays.fill(right, n);

        int maxarea = 0;
        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            // update height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            // update left
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') left[j] = Math.max(left[j], cur_left);
                else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            // update right
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
                else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            // update area
            for (int j = 0; j < n; j++) {
                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxarea;
    }

    public static void main(String[] args) {
        int result = new Solution().maximalRectangle(new char[][]{
                new char[]{'0','1','1','0','1'},
                new char[]{'1','1','0','1','0'},
                new char[]{'0','1','1','1','0'},
                new char[]{'1','1','1','1','0'},
                new char[]{'1','1','1','1','1'},
                new char[]{'0','0','0','0','0'},});
        System.out.println(result);
    }
}
