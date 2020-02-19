package leetcode.t383ransomnote;

import java.util.HashMap;
import java.util.Map;

/**
 * """""""""""""""""""""""""""""""""""""赎金信"""""""""""""""""""""""""""""""""""""
 *
 * 题意：
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 *
 * 注意：
 * 你可以假设两个字符串均只含有小写字母。
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Solution {

    /**
     * 可用信息存储到Map中进行使用，效率不高但易于理解
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charRepository = new HashMap<>();
        char[] magazineArray = magazine.toCharArray();
        // 1.得到字符仓库信息
        for (char c : magazineArray) {
            if (charRepository.containsKey(c)) {
                charRepository.put(c, charRepository.get(c) + 1);
            } else {
                charRepository.put(c, 1);
            }
        }
        char[] ransomNoteArray = ransomNote.toCharArray();
        for (char c : ransomNoteArray) {
            if (charRepository.containsKey(c)) {
                int num = charRepository.get(c);
                if (num -1 < 0) {
                    return false;
                }
                charRepository.put(c, charRepository.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canConstruct("abcf", "abcbfde"));
    }
}
