package leetcode.t005longestpalindromicsubstring;

/**
 * """""""""""""""""""""""""""""""""""""""""""""最长回文子串"""""""""""""""""""""""""""""""""""""""""""""
 *
 * 题意：
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Solution {

    public static void main(String[] args) {
        String x = new Solution().longestPalindrome("abac");
        System.out.println(x);
    }

    /**
     * longestPalindrome 马拉车算法
     * @param str
     * @return
     */
    public String longestPalindrome(String str) {
        String resultStr = "";
        if (str == null || str.length() == 0) {
            return resultStr;
        }
        // 获取到算法所需格式的字符串
        char[] charArr = manacherString(str);
        // 回文半径数组
        int[] curArr = new int[charArr.length];
        // 当前回文中心的索引
        int C = -1;
        //当前回文右边界
        int R = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++) {
            //i'的回文到r的距离，哪个小哪个就是回文的区域
            //2*index-i是当前索引关于回文中心的对称点即i'
            curArr[i] = R > i ? Math.min(curArr[2 * C - i], R - i) : 1;
            //要检验的区域没越界，且当前索引对应回文的左边边界也没有越界
            while (i + curArr[i] < charArr.length && i - curArr[i] > -1) {
                //扩充之后的左右两个值相等，回文半径+1
                //利用之前求出的半径加速判断
                if (charArr[i + curArr[i]] == charArr[i - curArr[i]]){
                    curArr[i]++;
                } else {
                    break;
                }
            }
            //统计回文半径
            if (i + curArr[i] > R) {
                R = i + curArr[i];
                C = i;
            }
            if (max < curArr[i]) {
                max = curArr[i];
                resultStr = String.valueOf(charArr).substring(C-max+1, C+max);
            }
        }
        return resultStr.replace("#","");
    }

    /**
     * 处理原始字符串使之更方便操作 (获取到manacher算法所需的字符串格式)
     * @param str
     * @return
     */
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

}
