package leetcode.theswordreferstooffer.t13jiqirendeyundongfanweilcof;

/**
 * @author Blaife
 * @description 面试题13 - 机器人的运动范围
 * @data 2020/4/8 14:36
 *
 * 题意：
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class Solution {
    /**
     * 功能描述: 获取机器人的运动范围
     * @author: Blaife
     * @date: 2020/4/8 15:12
     * @param m 高度
     * @param n 宽度
     * @param k 数位之和
     * @return: int
     */
    public int movingCount(int m, int n, int k) {
        // 控制每个位置的值，防止计算两次
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    /**
     * 功能描述: 深度优先搜索算法
     * @author: Blaife
     * @date: 2020/4/8 15:09
     * @param x 当前点x坐标
     * @param y 当前点y坐标
     * @param m 高
     * @param n 宽
     * @param k 数位之和
     * @param visited 当前值是否已计算
     * @return: int
     */
    private int dfs(int x, int y, int m, int n, int k, boolean[][] visited) {
        if (x == m || y == n || getNumericalDigit(x) + getNumericalDigit(y) > k || visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;
        // 可行区域在原点的右下方，所以只向右和向下拓展就行了
        return 1 + dfs(x + 1, y, m, n, k, visited) + dfs(x, y + 1, m, n, k, visited);
    }

    /**
     * 功能描述: 获取一个整数的数位和
     * @author: Blaife
     * @date: 2020/4/8 15:08
     * @param num 整数值
     * @return: int
     */
    private int getNumericalDigit(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(11, 8, 16));
    }
}
