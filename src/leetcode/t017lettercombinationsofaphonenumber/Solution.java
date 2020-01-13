package leetcode.t017lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.List;

/**
 * """""""""""""""""""""""""""""""""""""""""""""电话号码的字母组合"""""""""""""""""""""""""""""""""""""""""""""
 *
 * 题意：
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序
 */
public class Solution {


    /**
     * 回溯算法
     * 调用下一次方法时 发送的参数进行处理 而不提前处理 所以在走到终点时不需要对数据进行回滚
     * @param args
     */
    public static void main(String[] args) {
        List<String> x = new Solution().letterCombinations("23");
        System.out.println(x);
    }

    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() <= 0) {
            return result;
        }
        recall("", digits);
        return result;
    }

    /**
     * 回溯算法
     * @param list 当前字符串
     * @param digits 数字字符串（每次执行后吧最开头的数字删掉）
     */
    public void recall(String list, String digits) {
        if (digits.length() > 0) {
            char[] letterChar = getLetterByNum(digits.substring(0, 1));
            for (char c : letterChar) {
                recall(list+c, digits.substring(1));
            }
        } else {
            result.add(list);
        }
    }

    /**
     * 穷举所有类型 也可以执行使用map
     * @param num
     * @return
     */
    public char[] getLetterByNum(String num) {
        switch (num) {
            case "2":
                return new char[]{'a','b','c'};
            case "3":
                return new char[]{'d','e','f'};
            case "4":
                return new char[]{'g','h','i'};
            case "5":
                return new char[]{'j','k','l'};
            case "6":
                return new char[]{'m','o','n'};
            case "7":
                return new char[]{'p','q','r','s'};
            case "8":
                return new char[]{'t','u','v'};
            case "9":
                return new char[]{'w','x','y','z'};
            default:
                return new char[]{};
        }
    }
}
