package leetcode.t210coursescheduleii;

import java.util.*;

/**
 * @author Blaife
 * @description 210 - 课程表 II
 * @data 2020/5/17 21:19
 *
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 *
 * 示例 2:
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 说明:
 *
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 *
 * 提示:
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 *
 */
public class Solution {
    /**
     * 广度优先搜索
     * @param numCourses 总课程数
     * @param prerequisites 依赖关系
     * @return 学习顺序
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        // 建立入度表，即学习每门课对应的先修课门数。
        int[] in = new int[numCourses];
        // 定义数组依次存可以学完的课程。
        int[] ans = new int[numCourses];
        // 定义 list 数组存储所有作为其他课程先决条件出发的边。
        List[] edges = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        // 遍历先决条件边缘列表。
        for (int[] pre : prerequisites) {
            // 每有一门先决条件课，则当前课程入度表位置 +1 。
            in[pre[0]]++;
            // 将当前先决条件课出发的边加入数组对应的 list 中。
            edges[pre[1]].add(pre[0]);
        }
        // 定义队列辅助广度优先搜索。
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            // 将所有入度为 0 的课依次加入队列。
            if (in[i] == 0) {
                queue.offer(i);
            }
        }
        // 记录可以学完的课程门数。
        int count = 0;
        // 指定队列为空跳出循环。
        while (!queue.isEmpty()) {
            // 取出队列头的课程，因为没有先决条件，直接加入可以学习的课程数组。
            int curr = queue.poll();
            ans[count++] = curr;
            // 遍历以当前课程出发的边，即以当前课程为先决条件的课入度表对应位置 -1 。
            for (Object terminus : edges[curr]) {
                int t = (int) terminus;
                in[t]--;
                // 将入度变为 0 的课程加入队尾。
                if (in[t] == 0) {
                    queue.offer(t);
                }
            }
        }
        // 判断是否可以学完所有课程，返回最终结果。
        return count == numCourses ? ans : new int[0];
    }

}
