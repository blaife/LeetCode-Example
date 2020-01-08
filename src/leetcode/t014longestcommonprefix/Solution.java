package leetcode.t014longestcommonprefix;

/**
 * """"""""""""""""""""""""""""""""""""""""""""最长公共前缀""""""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class Solution {
    /**
     * 根据indexof进行判断 遍历所有
     * 先使用indexof判断是否一致，不一致在进行处理
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        // 过滤特殊情况
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 将下标为0的字串赋予prefix
        String prefix = strs[0];
        // 字串循环 从1开始
        for (int i = 1; i < strs.length; i++) {
            // 如果寻找的字符串中存在此子串，则直接返回
            // 如果不存在 则缩小子串进行处理
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
