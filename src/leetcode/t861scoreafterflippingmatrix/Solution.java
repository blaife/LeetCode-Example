package leetcode.t861scoreafterflippingmatrix;

/**
 * """"""""""""""""""""""""""""""" 翻转矩阵后的得分 """""""""""""""""""""""""""""""
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * 返回尽可能高的分数。
 *
 * 示例：
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 */
public class Solution {
    /**
     * 贪心算法
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        int ret = m * (1 << (n - 1));

        for (int j = 1; j < n; j++) {
            int nOnes = 0;
            for (int[] ints : A) {
                // 如果这一行进行了行反转，则该元素的实际取值为 1 - A[i][j]
                if (ints[0] == 1) {
                    nOnes += ints[j];
                } else {
                    nOnes += (1 - ints[j]);
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            ret += k * (1 << (n - j - 1));
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] x1 = new int[]{0,0,1,1};
        int[] x2 = new int[]{1,0,1,0};
        int[] x3 = new int[]{1,1,0,0};
        int[][] A = new int[][]{x1,x2,x3};
        int result = new Solution().matrixScore(A);
        System.out.println(result);
    }
}
