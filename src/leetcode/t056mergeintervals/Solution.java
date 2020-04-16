package leetcode.t056mergeintervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * """"""""""""""""""""""""""""""""""""""合并区间""""""""""""""""""""""""""""""""""""""
 * 题意：
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * @author Blaife
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        // 长度为0 则返回空的数组
        if (intervals == null || intervals.length == 0) {
            return res.toArray(new int[0][]);
        }

        // 对数组进行排序
        // Comparator： 使用比较器来对数组进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 对每队值进行判断合并
        for (int[] interval : intervals) {
            // res为空或者当前最大值小于判断值的最小值，则新加组
            // 否则则时可以合并，对最大值进行判断
            if (res.isEmpty() || res.getLast()[1] < interval[0]) {
                res.add(interval);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
            }
        }

        // 为什么放0，0长度？可以看下源码就知道了
        // 对参数的长度进行了判断，及更多的处理
        return res.toArray(new int[0][0]);
    }
}
