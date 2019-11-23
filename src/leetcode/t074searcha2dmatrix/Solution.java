package leetcode.t074searcha2dmatrix;

/**
 * """"""""""""""""""""""""""""""""""""""探索二维矩阵""""""""""""""""""""""""""""""""""""""
 *
 * 题意：
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 示例 1:
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 *
 * 示例 2:
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class Solution {

    /**
     * 思路 查找每行最后一个数，来确定去哪一行查找，
     * 如果目标数小于于当前数或者已到达行尾，则return false
     * 如果中途找到了目标数，则return true
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (target <= matrix[i][matrix[i].length-1]) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (target == matrix[i][j]) {
                        return true;
                    }
                    if (target < matrix[i][j]) {
                        return false;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[0][0];
        boolean b = new Solution().searchMatrix(matrix, 3);
        System.out.println(b);
    }
}
