package leetcode.t542onetwomatrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Blaife
 * @description 542 - 01矩阵
 * @data 2020/4/15 14:22
 * 题意：
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 */
public class Solution {

    /**
     * 功能描述: 多源BFS - 广度优先搜索
     * @author: Blaife
     * @date: 2020/4/15 20:51
     * @param matrix 初始矩阵
     * @return: int[][]
     */
    public int[][] updateMatrix(int[][] matrix) {

        /** 放置当前入队内容 **/
        Queue<int[]> queue = new LinkedList<>();

        // 找出为0的点 并且将为1的位置设置为-1， 表示未曾搜索到
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        // 向四个方向递归的数组
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};

        // 当队列不曾为空时，则一直循环
        while (!queue.isEmpty()) {
            // 得到当前的初始点
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            // 得到四个方向的延伸点
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离就可以更新成 matrix[x][y] + 1。
                if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }

        return matrix;
    }
}
