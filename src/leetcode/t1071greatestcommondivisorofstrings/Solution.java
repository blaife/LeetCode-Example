package leetcode.t1071greatestcommondivisorofstrings;

/**
 * """"""""""""""""""""""""""""""""""""""""""""""""字符串的最大公因子""""""""""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 * 示例 1：
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 *
 * 示例 2：
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 *
 * 示例 3：
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 */
public class Solution {

    /**
     * 辗转相除法
     * @param str1
     * @param str2
     * @return
     */
    public static String gcdOfStrings(String str1, String str2) {
        // 若A+B != B+A 则无法找到公因
        if(!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 如果A+B == B+A 则一定存在不为空的最大公因
        // 原因 假设他们是最大公因  则和即为最大公因的倍数 则A+B 与 B+A 一定相同
        // 执行递归方法
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    /**
     * 核心内容递归算法 两个值辗转相除
     * 此时确定存在最大公因，假设最大公因字符串长度为X, 则A=nX B=mX
     * 转换为数学问题，求最大公因数
     * @param a 值1 长度
     * @param b 值2 长度
     * @return
     */
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b , a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("asas", "asasas"));
    }
}
