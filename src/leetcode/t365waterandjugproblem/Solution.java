package leetcode.t365waterandjugproblem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * """"""""""""""""""""""""""""""""""""""""""""""""""""""水壶问题""""""""""""""""""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * 你允许：
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 *
 * 示例 1: (From the famous "Die Hard" example)
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 *
 * 示例 2:
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 */
public class Solution {
    /**
     * 贝祖定理（裴蜀定理）：最大公因数
     * @param x a壶容量
     * @param y b壶容量
     * @param z 所需容量
     * @return 是否可以的得到
     */
    public boolean canMeasureWater_Bezu(int x, int y, int z) {
        // 排除特殊情况
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z==0 || x + y == z;
        }
        return z % gcd(x, y) == 0;
    }

    /**
     * 得到最大公因数
     * @param x
     * @param y
     * @return
     */
    private int gcd(int x,int y) {
        return y==0 ? x : gcd(y, x % y);
    }

    /**
     * 广度优先搜索
     * @param x a壶容量
     * @param y b壶容量
     * @param z 所需容量
     * @return 是否可以的得到
     */
    public boolean canMeasureWater_BFS(int x, int y, int z) {
        // 排除特殊情况
        if (z < 0 || z > x + y) {
            return false;
        }
        // 存储数据，一方面检查是否有合适的答案，另一方面避免死循环
        Set<Integer> set = new HashSet<>();
        // 队列
        Queue<Integer> q = new LinkedList<>();
        // offer:添加元素
        q.offer(0);
        // 当前元素为0
        // 当前q为空时停止循环
        while (!q.isEmpty()) {
            // poll:返回第一个元素
            int n = q.poll();
            // 1:x壶进行处理
            if (n + x <= x + y && set.add(n + x)) {
                q.offer(n + x);
            }
            // 2:y壶进行处理
            if (n + y <= x + y && set.add(n + y)) {
                q.offer(n + y);
            }
            // 3:x壶进行处理
            if (n - x >= 0 && set.add(n - x)) {
                q.offer(n - x);
            }
            // 4:y壶进行处理
            if (n - y >= 0 && set.add(n - y)) {
                q.offer(n - y);
            }
            // 判断当前值时候有匹配项
            if (set.contains(z)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canMeasureWater_BFS(7, 9, 3));
    }
}