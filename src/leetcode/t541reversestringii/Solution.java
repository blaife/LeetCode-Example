package leetcode.t541reversestringii;

/**
 * """""""""""""""""""""""""""""""""""""""""""""""""反转字符串 II"""""""""""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，
 * 则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 *
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * 要求:
 * 该字符串只包含小写的英文字母。
 * 给定字符串的长度和 k 在[1, 10000]范围内。
 */
public class Solution {
    /**
     * （自己做的） -- 执行效率很差
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] sChar = s.toCharArray();
        // 获取倍数
        int times = sChar.length / k + 1;
        int sign = k/2;
        for (int i = 0; i < times / 2; i++) {
            for (int j = 0; j < sign; j++) {
                char temp = sChar[i * 2 * k + j];
                sChar[i * 2 * k + j] = sChar[i * 2 * k + k - j - 1];
                sChar[i * 2 * k + k - j - 1] = temp;
            }
        }
        if (times % 2 != 0 && sChar.length - (times-1) * k > 1) {
            for (int i = 0; i < (sChar.length - ((times - 1) * k)) / 2; i++) {
                char temp = sChar[(times-1) * k + i];
                sChar[(times-1) * k + i] = sChar[sChar.length - 1 - i];
                sChar[sChar.length - 1 - i] = temp;
            }
        }
        return new String(sChar);
    }

    /**
     * 官方版（想象与算法）
     * @param s
     * @param k
     * @return
     */
    public String reverseStr2(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr2("abcdefg", 8));
    }
}
