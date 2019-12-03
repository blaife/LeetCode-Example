package leetcode.t081searchinrotatedsortedarrayii;

/**
 * """""""""""""""""""""""""""""""""""""搜索旋转排序数组 II"""""""""""""""""""""""""""""""""""""
 * 题意：
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 *
 * 示例 2:
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 *
 * 进阶:
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 *
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        // 如果数组长度为0,则直接返回false
        if (nums.length == 0) {
            return false;
        }
        int Flip = 0; // 翻转点：准确来说是最小值
        // 查询反转点
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                Flip = i+1;
                break;
            }
        }
        // 最小值如果小于查找值，返回false
        if(nums[Flip] > target) {
            return false;
        }
        // 判断末尾值是否大于target
        if (nums[nums.length-1] > target) {
            // 第二部分循环
            for (int i = Flip; i < nums.length; i++) {
                if(nums[i] == target) {
                    return true;
                }
                if(nums[i] > target) {
                    return false;
                }
            }
        } else {
            // 第一部分循环
            for (int i = 0; i < Flip; i++) {
                if(nums[i] == target) {
                    return true;
                }
                if(nums[i] > target) {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{6,7,8,9,1,3,5,6}, 5));
    }
}
