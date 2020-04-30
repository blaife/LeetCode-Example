package leetcode.t202happynumber;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Blaife
 * @description 202 - 快乐数
 * @data 2020/4/30 10:03
 * 题意：
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 * 示例：
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Solution {

    /**
     * Set存储记录获得快乐数
     * @param n 验证数字
     * @return 是否是快乐数
     */
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        record.add(n);
        while (n != 1) {
            n = getQuadraticSum(n);
            if (record.contains(n)) {
                return false;
            }
            record.add(n);
        }
        return true;
    }

    /**
     * 获得一个数每个位置上的数字的平方和
     * @param num 一个数子
     * @return 平方和
     */
    public int getQuadraticSum(int num) {
        int result = 0;
        while (num > 0) {
            result += Math.pow(num % 10, 2);
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(2));
    }

}
