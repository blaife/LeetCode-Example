package leetcode.t686repeatedstringmatch;

/**
 * """""""""""""""""""""""""""""""""""""""""""""""重复叠加字符串匹配"""""""""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
 *
 * 举个例子，A = "abcd"，B = "cdabcdab"。
 * 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
 *
 * 注意:
 *  A 与 B 字符串的长度在1和10000区间范围内。
 *
 */
public class Solution {

    /**
     * 思路  若A的长度此时大于B的长度 最多叠加两次 此时若依旧无法匹配，返回-1
     * @param A
     * @param B
     * @return
     */
    public int repeatedStringMatch(String A, String B) {
        String paramA = A;
        int num = 1;
        while (num <= (B.length()/A.length()) + 2) {
            if (paramA.indexOf(B)  > -1) {
                return num;
            }
            paramA += A;
            num ++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().repeatedStringMatch("abcd", "cdabcdab"));

    }
}
