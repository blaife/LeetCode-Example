package leetcode.t434numberofsegmentsinastring;

/**
 * """"""""""""""""""""""""""""""""""""""字符串中的单词数""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 */
public class Solution {

    /**
     * 循环 找当前不为‘ ’且前一位为‘ ’的字符进行统计
     * @param s
     * @return
     */
    public int countSegments(String s) {
        int cnt = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                cnt ++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSegments(", , , ,        a, eaefa"));
    }
}
