package leetcode.interviewsatine.t1603intersectionlcci;

import java.util.Arrays;

/**
 * @author Blaife
 * @description 面试题 16.03 交点
 * @data 2020/4/12 17:20
 * 题意：
 * 给定两条线段（表示为起点start = {X1, Y1}和终点end = {X2, Y2}），如果它们有交点，请计算其交点，没有交点则返回空值。
 *
 * 要求浮点型误差不超过10^-6。若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点。
 *
 * 示例 1：
 * 输入：
 * line1 = {0, 0}, {1, 0}
 * line2 = {1, 1}, {0, -1}
 * 输出： {0.5, 0}
 *
 * 示例 2：
 * 输入：
 * line1 = {0, 0}, {3, 3}
 * line2 = {1, 1}, {2, 2}
 * 输出： {1, 1}
 *
 * 示例 3：
 * 输入：
 * line1 = {0, 0}, {1, 1}
 * line2 = {1, 0}, {2, 1}
 * 输出： {}，两条线段没有交点
 *  
 *
 * 提示：
 * 坐标绝对值不会超过 2^7
 * 输入的坐标均是有效的二维坐标
 */
public class Solution {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        // 确定两条线的四个端点
        int x1 = start1[0], y1 = start1[1];
        int x2 = end1[0], y2 = end1[1];
        int x3 = start2[0], y3 = start2[1];
        int x4 = end2[0], y4 = end2[1];
        // ans是最后需要输出的结果
        double[] ans = new double[2];
        // 将最大精度分配给目标数组
        Arrays.fill(ans, Double.MAX_VALUE);
        // 判断两直线是否平行 宽高比例相同则平行
        if ((y4-y3)*(x2-x1) == (y2-y1)*(x4-x3)) {
            // 判断两直线是否重叠 判断端点3是否在直线1上
            if ((y2-y1)*(x3-x1) == (y3-y1)*(x2-x1)) {
                // 判断 (x3, y3) 是否在「线段」(x1, y1)~(x2, y2) 上
                if (isInside(x1, y1, x2, y2, x3, y3)) {
                    updateRes(ans, x3, y3);
                }
                // 判断 (x4, y4) 是否在「线段」(x1, y1)~(x2, y2) 上
                if (isInside(x1, y1, x2, y2, x4, y4)) {
                    updateRes(ans, (double)x4, (double)y4);
                }
                // 判断 (x1, y1) 是否在「线段」(x3, y3)~(x4, y4) 上
                if (isInside(x3, y3, x4, y4, x1, y1)) {
                    updateRes(ans, (double)x1, (double)y1);
                }
                // 判断 (x2, y2) 是否在「线段」(x3, y3)~(x4, y4) 上
                if (isInside(x3, y3, x4, y4, x2, y2)) {
                    updateRes(ans, (double)x2, (double)y2);
                }
            }
        // 两直线不平行， 判断其是否相交
        } else {
            // t1 t2 为角度值
            double t1 = (double)(x3 * (y4 - y3) + y1 * (x4 - x3) - y3 * (x4 - x3) - x1 * (y4 - y3)) / ((x2 - x1) * (y4 - y3) - (x4 - x3) * (y2 - y1));
            double t2 = (double)(x1 * (y2 - y1) + y3 * (x2 - x1) - y1 * (x2 - x1) - x3 * (y2 - y1)) / ((x4 - x3) * (y2 - y1) - (x2 - x1) * (y4 - y3));
            // 判断 t1 和 t2 是否均在 [0, 1] 之间
            if (t1 >= 0.0 && t1 <= 1.0 && t2 >= 0.0 && t2 <= 1.0) {
                ans[0] = x1 + t1 * (x2 - x1);
                ans[1] = y1 + t1 * (y2 - y1);
            }
        }
        if (ans[0] == Double.MAX_VALUE) {
            return new double[0];
        }
        return ans;
    }

    /**
     * 功能描述: 判断 (x, y) 是否在「线段」(x1, y1)~(x2, y2) 上
     *          这里的前提是 (x, y) 一定在「直线」(x1, y1)~(x2, y2) 上
     * @author: Blaife
     * @date: 2020/4/12 17:44
     * @param x1 x1
     * @param y1 y1
     * @param x2 x2
     * @param y2 y2
     * @param x x
     * @param y y
     * @return: boolean
     */
    private boolean isInside(int x1, int y1, int x2, int y2, double x, double y) {
        // 若与 x 轴平行，只需要判断 x 的部分
        // 若与 y 轴平行，只需要判断 y 的部分
        // 若为普通线段，则都要判断
        if (x1 == x2 && Math.min(y1, y2) <= y && y <= Math.max(y1, y2))  {
            return true;
        }
        if (y1 == y2 && Math.min(x1, x2) <= x && x <= Math.max(x1, x2)) {
            return true;
        }
        if (Math.min(y1, y2) <= y && y <= Math.max(y1, y2) && Math.min(x1, x2) <= x && x <= Math.max(x1, x2)) {
            return true;
        }
        return false;
    }

    /**
     * 功能描述:
     * @author: Blaife
     * @date: 2020/4/12 17:37
     * @param ans 所需结果
     * @param x x位置
     * @param y y位置
     * @return: void
     */
    private void updateRes(double[] ans, double x, double y) {
        // 返回x值最小的点，x值相同则返回y值最小点
        if (x < ans[0] || (x == ans[0] && y < ans[1])) {
            ans[0] = x;
            ans[1] = y;
        }
    }

    public static void main(String[] args) {
        double[] result = new Solution().intersection(new int[]{0, 0}, new int[]{1, 0}, new int[]{1, 1}, new int[]{0, -1});
        for (double d : result) {
            System.out.println(d);
        }
    }
}
