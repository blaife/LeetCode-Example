package leetcode.interviewsatine.t0811coinlcci;

/**
 * @author Blaife
 * @description 08.11 硬币  （完全背包问题）
 * @data 2020/4/23 16:30
 */
public class CompletelyBackpack {
    /**
     * 功能描述: 完全背包解法
     * @author: Blaife
     * @date: 2020/4/23 15:57
     * @param n 总金额
     * @return: int
     */
    public int waysToChange(int n) {

        int[] dp = new int[n + 1];

        int[] coins = new int[]{1,5,10,25};

        //刚好可以用一个硬币凑成的情况，是一种情况
        // while i == coin :
        //dp[i] = dp[i - coin] => dp[0]
        dp[0] = 1;

        // dp方程：dp[i] += dp[i - coin];
        for(int coin : coins) {
            for(int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        System.out.println(dp[3]);
        return dp[n];
    }

    public static void main(String[] args) {
        new CompletelyBackpack().waysToChange(10000);
    }
}
