package leetcode.t400numberofislands;

/**
 * @author Blaife
 * @description 400 - 岛屿数量
 * @data 2020/4/20 16:18
 *
 * 题意：
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */
public class Solution {

    /**
     * 功能描述: DFS 深度优先搜索
     * @author: Blaife
     * @date: 2020/4/20 16:20
     * @param grid 海陆分布二维数组
     * @return: int
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                // 得到陆地后将相连陆地全部清空。
                // 方法执行完毕后 grid数组应全部为'0'
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }

    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        // 到达边界或者验证值为0 则停止循环
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        // 更改此位置的值，以免多次判断
        grid[r][c] = '0';
        // 从当前位置 向四个位置进行判断
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public static void main(String[] args) {
        int result = new Solution().numIslands(new char[][]{new char[]{'1', '1', '1'}, new char[]{'0', '1', '0'}, new char[]{'1', '1', '1'}});
        System.out.println(result);
    }
}
