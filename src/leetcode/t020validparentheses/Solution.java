package leetcode.t020validparentheses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * """""""""""""""""""""""""""""""""""""""""""""有效的括号"""""""""""""""""""""""""""""""""""""""""""""
 * 题意:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class Solution {

    /**
     * 思路：Stack+HashMap
     * 将字符串修改为char数组，我们从左往右开始进行判断，
     * 如果为左括号（"(","[","{"）则将其根据bracketMap的对应关系将其对应的右括号存入新的集合leftBrackedStrack。
     * 如果为右括号则将其与集合leftBrackedStrack的最后一个进行比较。若相同则删除集合尾元素并继续，不同则返回false
     * 如果数组循环完毕，但集合leftBrackedStrack不为空，返回false，否则返回true
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Character> bracketMap = new HashMap<Character, Character>();
        bracketMap.put('(', ')');
        bracketMap.put('[',']');
        bracketMap.put('{', '}');
        Stack<Character> leftBrackedStrack = new Stack<Character>();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                leftBrackedStrack.push(bracketMap.get(c));
            }
            if (c == ')' || c == ']' || c == '}') {
                if (leftBrackedStrack.isEmpty() || c != leftBrackedStrack.pop()) {
                    return false;
                }
            }
        }
        if (!leftBrackedStrack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("{}()[]"));
    }

}

















