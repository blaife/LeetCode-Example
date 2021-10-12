package leetcode.t040combinationsumii;

import java.util.*;

/**
 * @Description: 组合总和 II
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。 
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * @Author: blaife
 * @Date: 2021/10/12 16:01
 */
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, len, 0, target, path, res);

        return res;
    }

    /**
     * @param candidates 候选数组
     * @param len 总长度
     * @param begin 开始点
     * @param target 表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
     * @param path 根节点到叶子节点的路径
     * @param res
     */
    private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            /*
            * i > begin && candidates[i] == candidates[i-1]  和  Arrays.sort(candidates); 是此算法的核心
            *
            * 剪枝发生在：同一层数值其他相同的结点 （每次迭代的第一次循环时 i == begin）
            *
            * 如 【1,1,1,1,1,1,2】 4
            * 此时得到的路径为
            *
            *
            *   1）    1,1,1,1   √
            *   2）    1,1,1,2   ×
            *   3）    1,1,2     √
            *   4）    1,2       ×
            *
            *
            * */
            if (i > begin && candidates[i] == candidates[i-1]) {
                continue;
            }

            path.add(candidates[i]);
            dfs(candidates, len, i+1, target-candidates[i], path, res);

            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{1, 1, 2, 1, 1, 1};
        int target = 4;
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println("输出 => " + res);
    }

}
