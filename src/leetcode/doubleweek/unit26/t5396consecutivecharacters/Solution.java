package leetcode.doubleweek.unit26.t5396consecutivecharacters;

/**
 * @author Blaife
 * @description 5396 - 连续字符
 * @data 2020/5/16 22:36
 * 题意：
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 * 请你返回字符串的能量。
 *
 * 示例 1：
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 *
 * 示例 2：
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 *
 * 示例 3：
 * 输入：s = "triplepillooooow"
 * 输出：5
 *
 * 示例 4：
 * 输入：s = "hooraaaaaaaaaaay"
 * 输出：11
 *
 * 示例 5：
 * 输入：s = "tourist"
 * 输出：1
 *
 *
 * 提示：
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 */
public class Solution {

    public int maxPower(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int length = 1;
        int maxLength = 1;
        for (int i = 1; i < s.length(); i ++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                length ++;
            } else {
                length = 1;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxPower("abbcccddddeeeeedcba"));
    }
}