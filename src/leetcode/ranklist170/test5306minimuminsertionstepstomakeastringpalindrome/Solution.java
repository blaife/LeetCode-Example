package leetcode.ranklist170.test5306minimuminsertionstepstomakeastringpalindrome;

/**
 * """"""""""""""""""""""""""""""""""""""""""""让字符串成为回文串的最少插入次数""""""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
 *
 * 请你返回让 s 成为回文串的 最少操作次数 。
 *
 * 「回文串」是正读和反读都相同的字符串。
 *
 * 示例 1：
 * 输入：s = "zzazz"
 * 输出：0
 * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
 *
 * 示例 2：
 * 输入：s = "mbadm"
 * 输出：2
 * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
 *
 * 示例 3：
 * 输入：s = "leetcode"
 * 输出：5
 * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
 *
 * 示例 4：
 * 输入：s = "g"
 * 输出：0
 *
 * 示例 5：
 * 输入：s = "no"
 * 输出：1
 *
 *
 * 提示：
 * 1 <= s.length <= 500
 * s 中所有字符都是小写字母。
 */
public class Solution {
    public int minInsertions(String s) {
        // 将s转为char数组
        char[] chas = s.toCharArray();
        int n = chas.length;
        // dp存储可供使用的值(即是从字符串中排除的不需要额外插入的值)
        int[][] dp = new int[n][n];
        /**
         * 默认都是1，此时没有相同字符
         * 两值相等时，若两值之间有值的话此时可以排除的数据就有三个了
         *
         * 若输入leetcode，则dp矩阵为
         *
         * 1 1 2 2 2 2 2 3
         * 0 1 2 2 2 2 2 3
         * 0 0 1 1 1 1 1 3
         * 0 0 0 1 1 1 1 1
         * 0 0 0 0 1 1 1 1
         * 0 0 0 0 0 1 1 1
         * 0 0 0 0 0 0 1 1
         * 0 0 0 0 0 0 0 1
         *
         * 右上角的值为不需要插入对应值的数量
         */
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (chas[i] == chas[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[0][n-1]);
        return n-dp[0][n - 1];
    }


    public static void main(String[] args) {
        int x = new Solution().minInsertions("leetcode");
        System.out.println(x);
    }
}
