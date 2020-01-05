package leetcode.t013romantointeger;

/**
 * """""""""""""""""""""""""""""""""""""""""罗马数组转整数"""""""""""""""""""""""""""""""""""""""""
 * 题意:
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 * 输入: "III"
 * 输出: 3
 *
 * 示例 2:
 * 输入: "IV"
 * 输出: 4
 *
 * 示例 3:
 * 输入: "IX"
 * 输出: 9
 *
 * 示例 4:
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 *
 * 示例 5:
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class Solution {

    public static void main(String[] args) {
        int result = romanToInt("LVIII");
        System.out.println(result);
    }


    /**
     * 思路：穷举判断，每位相加
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int result = 0;
        int length = s.length()-1;
        while (length >= 0) {
            int romanChar = getIntByRoman(s, length);
            result += romanChar;
            // 判断一个数是4 或 9
            while (romanChar > 10) {
                romanChar /= 10;
            }
            if (romanChar == 4 || romanChar == 9) {
                length -= 2;
            } else {
                length --;
            }
        }
        return result;
    }

    /**
     * 每个字符进行判断，得到单个罗马数字的值
     * @param s
     * @param index
     * @return
     */
    public static int getIntByRoman(String s, int index) {
        switch (s.charAt(index)) {
            case 'M' : // 一千
                if (index > 0 && s.charAt(index-1) == 'C') {
                    return 900;
                } else {
                    return 1000;
                }
            case 'D' :
                if (index > 0 && s.charAt(index-1) == 'C') {
                    return 400;
                } else {
                    return 500;
                }
            case 'C' :
                if (index > 0 && s.charAt(index-1) == 'X') {
                    return 90;
                } else {
                    return 100;
                }
            case 'L' :
                if (index > 0 && s.charAt(index-1) == 'X') {
                    return 40;
                } else {
                    return 50;
                }
            case 'X' :
                if (index > 0 && s.charAt(index-1) == 'I') {
                    return 9;
                } else {
                    return 10;
                }
            case 'V' :
                if (index > 0 && s.charAt(index-1) == 'I') {
                    return 4;
                } else {
                    return 5;
                }
            case 'I' :
                return 1;
            default:
                return 0;
        }
    }
}
