package leetcode.t046permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Blaife
 * @description 046 - 全排列
 * @data 2020/4/25 9:50
 * 题意：
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class Solution {

    /**
     * 功能描述: 回溯算法
     * @Param: [n, output, res, first] 总长度， 数组内容， 返回的数据， 当前位下标
     * @Return: void
     * @Author: Blaife
     * @Date: 2020/4/25 10:03
     */
    public void backtrack(int n, ArrayList<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        // 调转两个位置的内容，执行完成后再恢复原样
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }


    /**
     * 功能描述: 回溯
     * @Param: [nums] 数组内容
     * @Return: List<List<Integer>>
     * @Author: Blaife
     * @Date: 2020/4/25 9:54
     */
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new LinkedList();

        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }
}
