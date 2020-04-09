package leetcode.t151reversewordsinastring;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Blaife
 * @description 151 - 翻转字符串里的单词
 * @data 2020/4/10 0:30
 * 题意：
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class Solution {
    /**
     * 功能描述: 正则表达式 截取后
     * @author: Blaife
     * @date: 2020/4/10 0:32
     * @param s
     * @return: java.lang.String
     */
    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        // 反转指定列表中元素的顺序
        Collections.reverse(wordList);
        // 拼接字符串
        return String.join(" ", wordList);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("  hello   world!  "));
    }
}
