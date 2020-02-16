package leetcode.t125validpalindrome;


/**
 * """"""""""""""""""""""""""""""""""""""""""验证回文串""""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class Solution {

    /**
     * ①：判断长度，等于0则直接返回true
     * ②：转小写，并转为char[]
     * ③：定义双指针，前后并行
     * ④：条件包括指针间隔，
     * ⑤：过滤掉无效字符，但前后指针字符相同时继续执行，不相同则返回false
     * ⑥：循环执行完毕则返回true
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }

        char[] sArray = s.toLowerCase().toCharArray();

        int left = 0;
        int right = s.length()-1;

        while (left < right) {
            while (!isRightful(sArray[left]) && left < right) {
                left++;
            }
            while (!isRightful(sArray[right]) && left < right) {
                right--;
            }
            if (sArray[left] != sArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 验证字符是否合法
     * @param c 字符
     * @return
     */
    public static boolean isRightful(char c) {
        if (c >= 48 && c <= 57) {
            return true;
        }
        if (c >= 97 && c <= 122) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("      "));
    }

}
