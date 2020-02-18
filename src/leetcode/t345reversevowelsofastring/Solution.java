package leetcode.t345reversevowelsofastring;

/**
 * """""""""""""""""""""""""""""""""""""""""""""""反转字符串"""""""""""""""""""""""""""""""""""""""""""""""
 *
 * 题意：
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 * 输入: "hello"
 * 输出: "holle"
 *
 * 示例 2:
 * 输入: "leetcode"
 * 输出: "leotcede"
 *
 * 说明:
 * 元音字母不包含字母"y"。
 * 元音字母包括（aeiouAEIOU）
 */
public class Solution {

    /**
     * 反转元音字符 -- 双指针处理
     * @param s 处理字符串
     * @return
     */
    public String reverseVowels(String s) {
        int leftIndex = 0;
        int rightIndex = s.length()-1;
        char[] sChar = s.toCharArray();
        while (leftIndex < rightIndex) {
            while (!isVowels(sChar[leftIndex]) && leftIndex < rightIndex) {
                leftIndex++;
            }
            while (!isVowels(sChar[rightIndex]) && leftIndex < rightIndex) {
                rightIndex--;
            }
            char params = sChar[leftIndex];
            sChar[leftIndex] = sChar[rightIndex];
            sChar[rightIndex] = params;
            leftIndex++;
            rightIndex--;
        }
        return String.valueOf(sChar);
    }

    /**
     * 验证字符是否是元音字符
     * @param c 验证字符
     */
    public static boolean isVowels(char c) {
        if ("aeiouAEIOU".indexOf(c) > -1) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("leetcode"));
    }
}
