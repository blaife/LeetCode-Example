package leetcode.array.t034findfirstandlastpositionofelementinsortedarray;

/**
 * 题意：
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 */
public class Solution {
    /**
     * 二分法，但是需要判断很多特殊情况 1.数组长度为0，2.长度为1，3.匹配值位于头尾
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int a = -1;
        int b = -1;
        if (nums.length == 0) {
            return new int[]{-1,-1};
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0,0};
            } else {
                return new int[]{-1,-1};
            }
        }
        int c = nums.length/2 - 1;
        if (nums[c] > target){
            for (int i = 0; i <= c; i ++) {
                if (nums[i] == target) {
                    if (a == -1) {
                        a = i;
                    }
                } else {
                    if (nums[i] != target) {
                        if (a != -1) {
                            b = i-1;
                            break;
                        }
                    }
                }
            }
        } else if (nums[c] < target) {
            for (int i = nums.length-1; i >= c; i--){
                if (nums[i] == target) {
                    if (b == -1) {
                        b = i;
                    }
                } else {
                    if (nums[i] != target) {
                        if (b != -1) {
                            a = i+1;
                            break;
                        }
                    }
                }
            }
        } else {
            a = c;
            b = c;
            while (a-1 >= 0 && nums[a-1] == target) {
                a--;
            }
            while (b+1 <= nums.length-1 && nums[b+1] == target) {
                b++;
            }
        }
        int[] res = new int[]{a,b};
        return res;
    }

    /**
     * 不执行二分法，感觉还更快了呢
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        int a = -1;
        int b = -1;
        for (int i = 0; i <= nums.length-1; i++) {
            if (nums[i] == target) {
                if (a == -1) {
                    a = i;
                }
            } else {
                if (nums[i] != target) {
                    if (a != -1) {
                        b = i-1;
                        break;
                    }
                }
            }
        }
        if (a != -1 && b == -1) {
            b = nums.length-1;
        }
        int[] res = new int[]{a,b};
        return res;
    }

    public static void main(String[] args) {
        int[] x = new Solution().searchRange2(new int[]{2,2}, 2);
        for (int res : x){
            System.out.print(res);
        }
    }
}
