package leetcode.doubleweek.unit26.t5397simplifiedfractions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Blaife
 * @description 5397 - 最简分数
 * @data 2020/5/16 22:49
 * 题意：
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
 *
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：["1/2"]
 * 解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
 *
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：["1/2","1/3","2/3"]
 *
 * 示例 3：
 * 输入：n = 4
 * 输出：["1/2","1/3","1/4","2/3","3/4"]
 * 解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
 *
 * 示例 4：
 * 输入：n = 1
 * 输出：[]
 *
 *
 * 提示：
 * 1 <= n <= 100
 */
public class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        if (n == 1) {
            return list;
        }
        for (int i = 2; i <= n; i ++) {
            for (int j = 1; j < i; j++) {
                if (getMaxDivisor(i, j) == 1) {
                    list.add(j+ "/" + i);
                }
            }
        }
        return list;
    }

    public int getMaxDivisor(int x, int y) {
        int remainder = x % y;
        if (remainder == 0) {
            return y;
        } else {
            return getMaxDivisor(y, remainder);
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifiedFractions(6));
    }
}
