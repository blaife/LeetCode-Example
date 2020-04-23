package leetcode.interviewsatine.t0811coinlcci;

/**
 * @author Blaife
 * @description 08.11 - 硬币
 * @data 2020/4/23 15:56
 * 题意：
 * 给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 *
 *  输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * 说明：
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= n (总金额) <= 1000000
 */
public class Solution {

    private static int[] coinArr = new int[]{25, 10, 5, 1};

    /**
     * 功能描述: 动态规划 ( 穷举 -- 超出时间限制 )
     * @author: Blaife
     * @date: 2020/4/23 15:57
     * @param n 总金额
     * @return: int
     */
    public int waysToChange(int n) {
        return analysis(n, 0);
    }

    /**
     * 功能描述: 递归算法 得到可能的方案
     * @author: Blaife
     * @date: 2020/4/23 16:13
     * @param n 剩余数目
     * @param index 最大可使用硬币数的下标
     * @return: int
     */
    private static int analysis(int n, int index) {
        int num = 0;
        if (n == 0) {
           return 1;
        } else {
            while (index < coinArr.length) {
                if (n >= coinArr[index]) {
                    num = (num + analysis(n - coinArr[index], index)) % 1000000007;
                }
                index++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int num = new Solution().waysToChange(10000);
        System.out.println(num);
    }

}
