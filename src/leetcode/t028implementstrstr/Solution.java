package leetcode.t028implementstrstr;

/**
 * """""""""""""""""""""""""""""""""""""""实现 strStr() 函数"""""""""""""""""""""""""""""""""""""""
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class Solution {

    public int strStr(String haystack, String needle) {
        // haystack.indexOf(needle) java的方法库中存在index方法，我们仿照其中的语法来写一下
        if (needle.length() > haystack.length()) { // 判断掉源字符长度小于匹配长度的情况
            return -1;
        }
        if (needle.length() == 0) { // 判断掉匹配字符长度为0的情况
            return 0;
        }
        char[] haystackChar = haystack.toCharArray(); // 源字符串转为char数组，便于之后的判断
        char[] needleChar = needle.toCharArray(); // 匹配字符串转为char数组，便于之后的判断
        char first = needleChar[0]; // 得到匹配字符串首字符，之后会多次用到
        int max = haystackChar.length - needleChar.length; // 源字符串可匹配的最大长度
        for (int i = 0; i <= max; i++) { // 循环开始
            if (haystackChar[i] != first) { // 首字符不匹配，源字符串指向字符向后移动
                while (++i <= max && haystackChar[i] != first); // 直到找到匹配第一个字符的位置
            }

            // 找到第一个匹配字符后判断其他字符（需要判断源字符位置）
            if (i <= max) {
                int j = i + 1; // 源字符要匹配的位置，向后移动一个
                int end = i + needleChar.length; // 判断匹配字符的最后一个字符是否匹配
                // 从第二个要匹配的字符开始，逐个匹配，知道结尾或匹配失败
                for (int k = 1; j < end && haystackChar[j] == needleChar[k]; j++, k++);
                // 匹配结束，全部匹配完成，则返回第一个匹配字符的位置
                if (j == end) {
                    return i;
                }
            }
        }
        // 匹配失败，返回-1
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("1354651asdasda","da"));
    }

}
