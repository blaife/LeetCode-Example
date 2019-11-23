package leetcode.t073setmatrixzeroes;

import java.util.Arrays;

/**
 * """"""""""""""""""""""""""""""""""""""矩阵置零""""""""""""""""""""""""""""""""""""""
 *
 * 题意：
 *  给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * 示例 2:
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 进阶:
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        /**
         * 思路：便利二维数组，确定那一行，那一列将设置为0
         */
        int[] x = new int[matrix.length];
        int[] y = new int[matrix[0].length];
        Arrays.fill(x,1);
        Arrays.fill(y,1);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    x[i] = 0;
                    y[j] = 0;
                }
            }
        }
        // 通过行修改
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 通过列修改
        for (int j = 0; j < y.length; j++) {
            if (y[j] == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{new int[]{1,1,1,0},new int[]{1,0,1,0},new int[]{1,1,1,0}};
        new Solution().setZeroes(matrix);
    }
}
