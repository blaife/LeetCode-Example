package leetcode.t520detectcapital;

/**
 * """"""""""""""""""""""""""""""""""""""""""检测大写字母""""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 *
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 *
 * 示例 1:
 * 输入: "USA" * 输出: True
 *
 * 示例 2:
 * 输入: "FlaG"
 * 输出: False
 * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
 */
public class Solution {

    /**
     * 不完全循环，找出所有错误情况
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        Boolean isFirstLower = true; // 默认首字母小写
        for (int i = 0; i < word.length(); i++) {
            // 当前字母大写情况
            if (word.charAt(i) - 'A' <= 25) {
                if (i == 0) { // 首字符则更改标识
                    isFirstLower = false;
                } else { // 非首字符则验证首字母是否小写及前一位是否小写（错误情况）
                    if (isFirstLower || word.charAt(i-1) - 'A' > 25) {
                        return false;
                    }
                }
            } else { // 当前字母小写
                // 从第三个字符进行合法判断，若前一位为大写则为错误情况
                if (i > 1 && word.charAt(i-1) - 'A' <= 25) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().detectCapitalUse("World"));
    }
}
