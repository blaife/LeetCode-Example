package leetcode.t064minimumpathsum;

/**
 * """"""""""""""""""""""""""""""""""""""""""最小路径和""""""""""""""""""""""""""""""""""""""""""
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 */
public class Solution {
    /**
     * 动态规划 类似于63，62
     * 到达每个位置的最小数是上面的数加左边的数，但不适用于第一行和第一列
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        for (int i = 0; i <= grid.length-1; i++) {
            for (int j = 0; j <= grid[i].length-1; j++) {
                int across = 0;
                int vertical = 0;
                if (j > 0) {
                    across = grid[i][j - 1];
                }
                if (i > 0) {
                    vertical = grid[i - 1][j];
                }
                if (i==0 || j == 0) {
                    grid[i][j] += Math.max(across, vertical);
                }
                grid[i][j] += Math.min(across, vertical);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{new int[]{1,3,1}, new int[]{1,5,1}, new int[]{4,2,1}};
        int result = new Solution().minPathSum(obstacleGrid);
        System.out.println(result);
    }
}
