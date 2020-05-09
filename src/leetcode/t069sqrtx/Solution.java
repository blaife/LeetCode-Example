package leetcode.t069sqrtx;

import javax.sound.midi.Soundbank;

/**
 * """""""""""""""""""""""""""""""""""""""""""""""""""x 的平方根"""""""""""""""""""""""""""""""""""""""""""""""""""
 *
 * 题意：
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 */
public class Solution {

    /**
     * 数学公式法 （java Math工具类中的sqrt方法使用的并非数学法）
     * @param x 原值
     * @return 平方根
     */
    public int mySqrt(int x) {
        // sqrt ： return (int) Math.sqrt(x);
        if (x < 2) {
            return x;
        }

        int left = (int)Math.pow(Math.E, 0.5 * Math.log(x));
        int right = left + 1;
        return (long)right * right > x ? left : right;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(8));
    }
}
