package leetcode.t036validsudoku;

import java.util.*;

/**
 * """"""""""""""""""""""""""""""""""""""""""""有效的数独""""""""""""""""""""""""""""""""""""""""""""
 *
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 *
 * 示例 2:
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 *
 */
public class Solution {
    /**
     * 验证数独
     * @param board 确定9*9
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // 初始化数据
        HashMap<Character, Integer> [] rows = new HashMap[9]; // 行
        HashMap<Character, Integer> [] columns = new HashMap[9]; // 列
        HashMap<Character, Integer> [] boxes = new HashMap[9]; // 方块
        for (int i = 0; i < 9; i++) { // 出书化所有区域
            rows[i] = new HashMap<Character, Integer>();
            columns[i] = new HashMap<Character, Integer>();
            boxes[i] = new HashMap<Character, Integer>();
        }

        // 验证部分
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j]; // 得到当前的值
                if (num != '.') { // num为有效值

                    int box_index = (i / 3 ) * 3 + j / 3; // 判断当前值在哪个方块区域内

                    // 保持当前单元格值
                    // getOrDefault(key, defaultValue) 当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
                    // 注意：验证的时key而不是value
                    rows[i].put(num, rows[i].getOrDefault(num, 0) + 1); //
                    columns[j].put(num, columns[j].getOrDefault(num, 0) + 1);
                    boxes[box_index].put(num, boxes[box_index].getOrDefault(num, 0) + 1);

                    // 检查这个值之前是否已经被存储到
                    if (rows[i].get(num) > 1 || columns[j].get(num) > 1 || boxes[box_index].get(num) > 1)
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[9][9];
        board[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        board[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        board[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        board[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        board[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        board[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        board[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        board[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        board[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};

        System.out.println(new Solution().isValidSudoku(board));
    }

}
