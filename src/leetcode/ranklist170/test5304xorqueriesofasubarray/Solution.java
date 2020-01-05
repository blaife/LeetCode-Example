package leetcode.ranklist170.test5304xorqueriesofasubarray;

import java.util.Arrays;

/**
 * """"""""""""""""""""""""""""""""子数组异或查询""""""""""""""""""""""""""""""""
 *
 * 题意：
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 * 并返回一个包含给定查询 queries 所有结果的数组。
 *
 * 示例 1：
 *
 * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * 输出：[2,7,14,8]
 * 解释：
 * 数组中元素的二进制表示形式是：
 * 1 = 0001
 * 3 = 0011
 * 4 = 0100
 * 8 = 1000
 * 查询的 XOR 值为：
 * [0,1] = 1 xor 3 = 2
 * [1,2] = 3 xor 4 = 7
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14
 * [3,3] = 8
 * 示例 2：
 *
 * 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * 输出：[8,0,4,4]
 */
public class Solution {

    public int[] xorQueries(int[] arr, int[][] queries) {
        // 要输出的数组应该与原数组长度一致，将其默认赋值为0
        int[] result = new int[queries.length];
        // 默认赋值为0的原因是需要 0与x异或为x
        Arrays.fill(result, 0);
        // 对数组进行循环
        for (int i = 0; i < queries.length; i++) {
            int index1 = queries[i][0]; // 左顶点
            int index2 = queries[i][1]; // 有顶点
            while (index2 - index1 >= 0) {
                result[i] ^= arr[index1]; // 每次使用数组原数据进行异或操作
                index1 ++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] x = new Solution().xorQueries(new int[]{1, 3, 4, 8}, new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{0, 3}, new int[]{3, 3}});
        for (int n: x) {
            System.out.print(n);
        }
    }
}
