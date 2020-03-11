package leetcode.t1013partitionarrayintothreepartswithequalsum;

/**
 * """""""""""""""""""""""""""""""""""""""""""将数组分成和相等的三个部分"""""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *
 * 形式上，如果可以找出索引 i+1 < j 且满足 
 * (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 
 * 就可以将数组三等分。
 *
 */
public class Solution {

    /**
     * 判断和是否为3的倍数
     * 左右双指针获取值 若左右都可以得到平均值 和中间部分也一定是平均值
     * @param A
     * @return
     */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        // 如果和不为3的倍数
        if (sum % 3 != 0) {
            return false;
        }
        // 平均值
        int avg = sum / 3;
        // 左右指针
        int i = 0, j = A.length - 1;
        // 两组值 判断是否可以等分
        int lans = A[i], rans = A[j];
        while (i + 1 < j) {

            if (lans == avg && rans == avg) {
                return true;
            }

            if (lans != avg) {
                lans += A[++i];
            }

            if (rans != avg) {
                rans += A[--j];
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canThreePartsEqualSum(new int[]{1, -1, 1, -1}));
    }
}
