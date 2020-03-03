package leetcode.t557reversewordsinastringiii;

/**
 * """"""""""""""""""""""""""""""""""""""""""""反转字符串中的单词 III""""""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class Solution {
    /**
     * 双指针
     * 指向单词开头和结尾
     * 案例可优化，目前有冗余代码
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        char[] sChars = s.toCharArray();
        int start = -1;
        int end;
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != ' ' && start == -1) {
                start = i;
            }
            if (sChars[i] == ' ' && start != -1) {
                if (start != i-1) {
                    end = i-1;
                    while (start < end) {
                        char param = sChars[start];
                        sChars[start] = sChars[end];
                        sChars[end] = param;
                        start++;
                        end--;
                    }
                }
                start = -1;
            }
        }
        if (start != -1) {
            end = sChars.length-1;
            while (start < end) {
                char param = sChars[start];
                sChars[start] = sChars[end];
                sChars[end] = param;
                start++;
                end--;
            }
        }
        return new String(sChars);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
    }
}
