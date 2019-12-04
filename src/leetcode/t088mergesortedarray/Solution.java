package leetcode.t088mergesortedarray;

import java.util.Arrays;

/**
 * """"""""""""""""""""""""""""""合并两个有序数组""""""""""""""""""""""""""""""
 * 题意：
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 */
public class Solution {
    /**
     * 思路：先将nums2中的数据全部转移到nums1中，然后对nums1排序
     * 即：先合并后排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
