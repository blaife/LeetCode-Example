package leetcode.t551studentattendancerecordi;

/**
 * """"""""""""""""""""""""""""""""""""""""""""""""""学生出勤记录 I""""""""""""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 *
 * 示例 1:
 * 输入: "PPALLP"
 * 输出: True
 *
 * 示例 2:
 * 输入: "PPALLL"
 * 输出: False
 */
public class Solution {
    public boolean checkRecord(String s) {
        // 判断A时候达标
        if(s.indexOf("A") > -1 && s.indexOf("A", s.indexOf("A") + 1) > -1) {
            System.out.println("A");
            return false;
        }
        // 判断LLL是否达标
        if (s.indexOf("LLL") > -1) {
            System.out.println("LL");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkRecord("PPALLP"));
    }
}
