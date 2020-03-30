package leetcode.theswordreferstooffer.t62yuanquanzhongzuihoushengxiadeshuzilcof;

/**
 * @author Blaife
 * @description 剑指offer : 62. 圆圈中最后剩下的数字
 * @data 2020/3/30 15:09
 *
 * 题意：
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 示例 1：
 * 输入: n = 5, m = 3
 * 输出: 3
 *
 * 示例 2：
 * 输入: n = 10, m = 17
 * 输出: 2
 *  
 * 限制：
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 */
public class Solution {
    /**
     * 功能描述: 数学解法：约瑟夫环  f(N,M)=(f(N−1,M)+M)%N
     *      f(N,M)表示，N个人报数，每报到M时杀掉那个人，最终胜利者的编号
     *      f(N−1,M)f(N-1,M)f(N−1,M)表示，N-1个人报数，每报到M时杀掉那个人，最终胜利者的编号
     * @author: Blaife
     * @date: 2020/3/30 15:18
     * @param n 总数
     * @param m 移除的位置标识
     * @return: int 最后留下的数
     */
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lastRemaining(11, 2));
    }
}
