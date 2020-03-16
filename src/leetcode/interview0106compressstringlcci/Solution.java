package leetcode.interview0106compressstringlcci;

/**
 * """""""""""""""""""""""""""""""""""""""""""""面试题 01.06. 字符串压缩"""""""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 *
 * 示例2:
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 *
 * 提示：
 * 字符串长度在[0, 50000]范围内。
 *
 */
public class Solution {
    public String compressString(String S) {
        // 排除空字符情况 （之后会使用字符长度-1判断）
        if (S.length() == 0) {
            return "";
        }
        // 组装的字符
        StringBuffer sb = new StringBuffer();
        // 当前字符出现次数
        int number = 0;
        // 循环判断
        for (int i = 0; i < S.length(); i++) {
            // 第一个或者与前一位相同，则数量+1
            if (i-1 < 0 || S.charAt(i) == S.charAt(i-1)) {
                number++;
            // 不相同则需要把之前记录的添加到sb中，并且当前字符数量为1进行当前字符的处理
            // 字符判断则是当前处理位的前一位
            } else {
                sb.append(S.substring(i-1, i) + number + "");
                number = 1;
            }
        }
        // 把最后一个相同的字符组添加到sb中
        sb.append(S.substring(S.length()-1) + number + "");
        // 判断长度决定输出原字符或处理后的字符
        if (sb.toString().length() < S.length()) {
            return sb.toString();
        } else {
            return S;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compressString(""));
    }
}
