package leetcode.t006zigzagconversion;

import java.util.ArrayList;
import java.util.List;

/**
 * """""""""""""""""""""""""""""""""""""Z 字形变换"""""""""""""""""""""""""""""""""""""
 *
 * 题意：
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Solution {

    public String convert(String s, int numRows) {
        // 如果只有一行 或者 s的长度小于等于numRows 则直接输出s
        if (numRows == 1 || s.length() <= numRows) return s;

        // 行信息存储
        List<StringBuilder> rows = new ArrayList<>();

        // 获取行信息 共有几行
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0; // 下标
        boolean goingDown = false; // 往下走还是往上走

        // 循环存储数据
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c); // 将字符存入rows
            // 通过 0 和 numRows-1 来确定转折
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            // 通过goingDown来确定走向
            curRow += goingDown ? 1 : -1;
        }
        // 要输出的内容
        StringBuilder ret = new StringBuilder();
        // 循环拼接字符串
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

}
