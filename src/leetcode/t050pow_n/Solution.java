package leetcode.t050pow_n;

/**
 * @author Blaife
 * @description 50 - Pow(x, n)
 * @data 2020/5/11 11:35
 * 题意：
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2的31次幂, 2的31次幂 − 1] 。
 */
public class Solution {

    /**
     * 快速幂
     * @param x 原数字
     * @param N 幂次
     * @return 结果
     */
    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * 快速幂 + 递归
     * /2 二分处理 解决掉奇偶之间的不同
     * @param x 原数字
     * @param n 幂次数
     * @return 结果
     */
    public double myPow(double x, int n) {
        long N = n;
        // 判断正负 若正 则直接输入， 若负 结果需要1/正数结果
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(1.1, -2));
    }
}
