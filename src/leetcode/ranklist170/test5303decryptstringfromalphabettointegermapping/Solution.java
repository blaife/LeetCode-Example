package leetcode.ranklist170.test5303decryptstringfromalphabettointegermapping;

/**
 * """""""""""""""""""""""""""""""""""""解码字母到整数映射"""""""""""""""""""""""""""""""""""""
 *
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 *
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
 * 返回映射之后形成的新字符串。
 *
 * 题目数据保证映射始终唯一。
 *
 * 示例 1：
 * 输入：s = "10#11#12"
 * 输出："jkab"
 * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 *
 * 示例 2：
 * 输入：s = "1326#"
 * 输出："acz"
 *
 * 示例 3：
 * 输入：s = "25#"
 * 输出："y"
 *
 * 示例 4：
 * 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * 输出："abcdefghijklmnopqrstuvwxyz"
 * 提示：
 * 1 <= s.length <= 1000
 * s[i] 只包含数字（'0'-'9'）和 '#' 字符。
 * s 是映射始终存在的有效字符串。
 */
public class Solution {

    /**
     * 从右到左处理数子
     * @param s
     * @return
     */
    public String freqAlphabets(String s) {
        // 需要字符串拼接，用到StringBuffer
        StringBuffer result = new StringBuffer();
        int length = s.length();
        // 循环，每次循环后length-1 或 length-3
        while (length > 0) {
            int x = 0; // 变量值 接收处理后的数字
            if (s.charAt(length-1) == '#') { // 10 - 26
                // 截取字符后转换为int
                x = Integer.parseInt(s.substring(length-3, length-1));
                length -= 3;// XX# 所以是删除3个字符
            } else { // 0 - 9
                // 截取字符后转换为int
                x = Integer.parseInt(s.substring(length-1, length));
                length --; // 删除一个字符
            }
            // 通过Unicode编码使数据进行转换 1 —> a || 1 -> 97
            char letter = (char)(x + 96);
            // StringBuffer的insert方法实现每次得到的字母放在字符串头部
            result.insert(0, letter);
        }
        return result.toString();
    };

    public static void main(String[] args) {
        new Solution().freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#");
    }
}