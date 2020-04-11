package leetcode.t887supereggdrop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Blaife
 * @description 887 - 鸡蛋掉落
 * @data 2020/4/11 21:34
 * 题意：
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 你的目标是确切地知道 F 的值是多少。
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 * 示例 1：
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 *
 * 示例 2：
 * 输入：K = 2, N = 6
 * 输出：3
 *
 * 示例 3：
 * 输入：K = 3, N = 14
 * 输出：4
 *  
 * 提示：
 * 1 <= K <= 100
 * 1 <= N <= 10000
 */
public class Solution {

    /**
     * 功能描述: 动态规划 + 二分法
     * @author: Blaife
     * @date: 2020/4/11 21:38
     * @param K 鸡蛋个数
     * @param N 楼层数
     * @return: int
     */
    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    /**
     * 存储的楼层个数和鸡蛋数
     */
    Map<Integer, Integer> memo = new HashMap();


    /**
     * 功能描述:
     * @author: Blaife
     * @date: 2020/4/11 21:39
     * @param K 鸡蛋个数
     * @param N 楼层数
     * @return: int
     */
    public int dp(int K, int N) {
        // 如果存在其情况，则直接输出
        if (!memo.containsKey(N * 100 + K)) {
            /*
             * ans 所需次数
             */
            int ans;
            // 当前鸡蛋数为0
            if (N == 0) {
                ans = 0;
                // 当前鸡蛋数为1
            } else if (K == 1) {
                ans = N;
                // 当前鸡蛋数大于1
            } else {
                int lo = 1, hi = N;
                // 从第一层到第n层循环遍历测试
                while (lo + 1 < hi) {
                    // 二分
                    int x = (lo + hi) / 2;
                    /*
                     * 分为两段
                     * 1. 鸡蛋碎了： 鸡蛋数量-1. 层数变为所扔层数的下半部分
                     * 2. 鸡蛋没碎： 鸡蛋数量不变，层数变为所扔层数的上半部分
                     */
                    int t1 = dp(K-1, x-1);
                    int t2 = dp(K, N-x);

                    if (t1 < t2) {
                        lo = x;
                    } else if (t1 > t2) {
                        hi = x;
                    } else {
                        lo = hi = x;
                    }
                }

                ans = 1 + Math.min(Math.max(dp(K-1, lo-1), dp(K, N-lo)),
                        Math.max(dp(K-1, hi-1), dp(K, N-hi)));
            }

            memo.put(N * 100 + K, ans);
        }

        return memo.get(N * 100 + K);
    }

    /**
     * 功能描述: 数学法
     *          f(T,K)=1+f(T−1,K−1)+f(T−1,K)
     * @author: Blaife
     * @date: 2020/4/11 22:26
     * @param K 鸡蛋个数
     * @param N 楼层数
     * @return: int
     */
    public int superEggDrop_Math(int K, int N) {
        if (N == 1) {
            return 1;
        }
        int[][] f = new int[N + 1][K + 1];
        for (int i = 1; i <= K; ++i) {
            f[1][i] = 1;
        }
        int ans = -1;
        for (int i = 2; i <= N; ++i) {
            for (int j = 1; j <= K; ++j) {
                f[i][j] = 1 + f[i - 1][j - 1] + f[i - 1][j];
            }
            if (f[i][K] >= N) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().superEggDrop_Math(2, 100));
    }
}
