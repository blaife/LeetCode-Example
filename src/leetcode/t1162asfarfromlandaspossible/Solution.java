package leetcode.t1162asfarfromlandaspossible;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * """"""""""""""""""""""""""""""""""""""""""""""""""""""地图分析""""""""""""""""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 * 示例 1：
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 *
 * 示例 2：
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *  
 *
 * 提示：
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 *
 * @author Blaife
 */
public class Solution {
    /**
     * BFS：广度优先搜索
     * @param grid 陆海分布数组
     * @return 最远距离
     */
    public int maxDistance(int[][] grid) {
        // 进行外扩搜索时使用
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        // 队列
        Queue<int[]> queue = new ArrayDeque<>();
        // 陆海范围（长,宽）
        int m = grid.length, n = grid[0].length;
        // 先把所有的陆地都入队。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        boolean hasOcean = false;
        // 当前陆地的位置信息
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];
            // 从当前陆地位置向四周扩展
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // grid[newX][newY] != 0 : 若此时得到的相邻值不是海洋， 则不进行下一步处理
                // 相当于,每一个位置都只能进入队列一次.
                if(newX < 0 || newY < 0 || newX >= m || newY >= n || grid[newX][newY] != 0) {
                    continue;
                }
                grid[newX][newY] = grid[x][y] + 1;
                hasOcean = true;
                queue.offer(new int[]{newX, newY});
            }
        }
        // 没有陆地或者没有海洋，返回-1。
        if (point == null || !hasOcean) {
            return -1;
        }



        // 返回最后一次遍历到的海洋的距离。
        return grid[point[0]][point[1]] - 1;
    }

    public static void main(String[] args) {
        int result = new Solution().maxDistance(new int[][]{new int[]{1,0,1}, new int[]{0,0,0}, new int[]{1,0,1}});
        System.out.println(result);
    }
}
