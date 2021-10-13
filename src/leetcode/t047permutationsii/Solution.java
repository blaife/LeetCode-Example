package leetcode.t047permutationsii;

import java.util.*;

/**
 * @Description: 全排列 II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * @Author: blaife
 * @Date: 2021/10/12 16:38
 */
public class Solution {

    boolean[] vis;

    /**
     * 我们一定保证每次都是拿从左往右第一个未被填过的数字，
     * 即整个数组的状态其实是保证了
     * [未填入，未填入，未填入] 到 [填入，未填入，未填入]，
     * 再到 [填入，填入，未填入]，最后到 [填入，填入，填入] 的过程的，
     *
     * 因此可以达到去重的目标。
     *
     * @param nums
     * @param res
     * @param idx
     * @param output
     */
    public void backtrack(int[] nums, List<List<Integer>> res, int idx, ArrayList<Integer> output) {
        // 所有数都填完了
        if (idx == nums.length) {
            res.add(new ArrayList<Integer>(output));
            return;
        }

        // 调转两个位置的内容，执行完成后再恢复原样
        for (int i = 0; i < nums.length; ++i) {
            // 使 重复值保持其顺序
            if (vis[i] || (i > 0 && nums[i] == nums[i-1] && !vis[i-1])) {
                continue;
            }
            output.add(nums[i]);
            vis[i] = true;
            backtrack(nums, res, idx + 1, output);
            vis[i] = false;
            output.remove(idx);
        }
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList();

        ArrayList<Integer> output = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, res, 0, output);
        return res;
    }


    public static void main(String[] args) {
        int[] candidates = new int[]{1,2,2};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permuteUnique(candidates);
        System.out.println("输出 => " + res);
    }
}


