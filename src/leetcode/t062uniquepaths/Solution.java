package leetcode.t062uniquepaths;

import java.util.Arrays;

/**
 * """"""""""""""""""""""""""""""""""""""""不同路径""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 */
public class Solution {
    /**
     * 向下向右移动的次数是固定的，离散数学函数
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        // C((m+n-2)/min(m,n));
        return 0;
    };

    /**
     * 动态规划
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }

    public static void main(String[] args) {
        int result = new Solution().uniquePaths2(3, 3);
        System.out.println(result);
    }
}
