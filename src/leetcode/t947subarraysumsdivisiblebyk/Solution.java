package leetcode.t947subarraysumsdivisiblebyk;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Blaife
 * @description 947 - 和可被 K 整除的子数组
 * @data 2020/5/27 22:06
 *
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 * 示例：
 *
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *  
 *
 * 提示：
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 */
public class Solution {

    /**
     * 超出时间限制
     */
    public int subarraysDivByK(int[] A, int K) {
        int[] B = A;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j < i) {
                    B[j] += A[i];
                }
                if (B[j] % K == 0) {
                   count++;
                }
            }
        }
        return count;
    }

    /**
     * 哈希表 + 逐一统计
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK2(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
    }
}
