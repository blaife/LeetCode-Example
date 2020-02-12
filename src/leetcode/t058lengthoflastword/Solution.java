package leetcode.t058lengthoflastword;

/**
 * """"""""""""""""""""""""""""""""""""""""""""""最后一个单词的长度""""""""""""""""""""""""""""""""""""""""""""""
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
 * 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指仅由字母组成、不包含任何空格的 最大子字符串。
 *
 *
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 *
 */
public class Solution {

    /**
     * 我们只需要找到最后一个单词前面的空格就可以了,循环遍历（正则可能会更加简单快速一点）
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int from = s.length()-1; // 起始点
        int left = s.lastIndexOf(" ", from);
        while (left == from && left > 0){
            from--;
            left = s.lastIndexOf(" ", from);
        }
        int result = from-left;
        if (result < 0) {
            return 0;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("   "));
    }

}
