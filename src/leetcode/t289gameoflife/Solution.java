package leetcode.t289gameoflife;

/**
 * @author Blaife
 * @description 289 - 生命游戏
 * @data 2020/4/2 15:54
 * 题意:
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 * 示例：
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *  
 *
 * 进阶：
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 */
public class Solution {
    /**
     * 功能描述: 使用二进制运算进行处理
     * 0： 死亡   1： 存货  2： 下一时刻存活但当前死亡  3： 下一时刻存货，当前也存活
     * 即 0, 0, 10, 11
     * 使用 & 与运算 和 >> 位运算进行处理
     * @author: Blaife
     * @date: 2020/4/2 16:49
     * @param board 原存货状态二维数组
     * @return: void
     */
    public void gameOfLife(int[][] board) {
        // 排除数组为空的情况
        if (board.length == 0) {
            return;
        }

        // 定义偏移量数组
        int[] arrX = {1, 0, -1, 1, -1, 1, 0, -1};
        int[] arrY = {1, 1, 1, 0, 0, -1, -1, -1};

        // 循环对元素组进行处理
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 周围存货数
                int aroundNum = 0;
                for (int num = 0; num < 8; num++) {
                    int currentX = j + arrX[num];
                    int currentY = i + arrY[num];
                    if (currentX < 0 || currentY < 0 || currentX >= board[i].length || currentY >= board.length ) {
                        continue;
                    }
                    // 与运算1和3为 原存活
                    if ((board[currentY][currentX] & 1) == 1) {
                        aroundNum ++;
                    }
                }
                // 当前位置为存活
                if (board[i][j] == 1) {
                    if (aroundNum >= 2 && aroundNum <= 3) {
                        board[i][j] = 3;
                    }
                    // 当前位置为死亡
                } else  {
                    if (aroundNum == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] >>= 1;
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Solution().gameOfLife(new int[][]{new int[]{0, 1, 0}, new int[]{0, 0, 1}, new int[]{1, 1, 1}, new int[]{0, 0, 0}});
    }
}
