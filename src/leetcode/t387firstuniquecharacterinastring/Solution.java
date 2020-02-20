package leetcode.t387firstuniquecharacterinastring;

import java.nio.charset.CharsetEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * """""""""""""""""""""""""""""""""""""""""字符串中的第一个唯一字符"""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 * s = "leetcode"
 * 返回 0.
 * s = "loveleetcode",
 * 返回 2.
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class Solution {

    /**
     * 建立仓库 存储字符，
     * getOrDefault：存在则输出，不存在则设置默认值后输出
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> repositoryMap = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            repositoryMap.put(c, repositoryMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (repositoryMap.get(s.charAt(i)) == 1) {
                 return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new Solution().firstUniqChar("leetcode");
    }

}
