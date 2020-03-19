package leetcode.t409longestpalindrome;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * """"""""""""""""""""""""""""""""""""""""""""""""""""""最长回文串""""""""""""""""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class Solution {
    /**
     * 一次循环，定义一个Set集合，将大部当前字符存储进去
     * 若得到集合中存在的字符则长度+2,并删除集合中的对应元素
     * 循环结束后，若集合中存在元素，则长度+1
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int result = 0;
        Set<Character> mySet = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!mySet.contains(c)) {
                mySet.add(c);
            } else {
                mySet.remove(c);
                result += 2;
            }
        }
        if (!mySet.isEmpty()) {
            result++;
        }
        return result;
    }

    /**
     * 贪心算法（使用数组，字符对应下标值）
     * @param s
     * @return
     */
    public int longestPalindrome2(String s) {
        // 大写+小写最大的对应值为128
        int[] count = new int[128];
        // 每次令对应位置的字符+1
        for (char c: s.toCharArray()){
            count[c]++;
        }
        // ans为了统计最后的数量
        int ans = 0;
        // 对数组进行循环
        for (int v: count) {
            ans += v / 2 * 2;
            // 以下分支最多只能执行一次，因为执行一次之后ans为2的倍数+1
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("asdaqfascazsdcadfaqqfadgvdsfhawfxcdvbasd"));
    }
}
