package leetcode.theswordreferstooffer.t51shuzuzhongdenixuduilcof;

/**
 * @author Blaife
 * @description 面试题 51 - 数组中的逆序对
 * @data 2020/4/24 11:01
 * 题意：
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 *  
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 */
public class Solution {

    /**
     * 功能描述: 归并排序
     * @Param: [nums] 原数组
     * @Return: int
     * @Author: Blaife
     * @Date: 2020/4/24 11:22
     */
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int[] copy = new int[len];
        // 从指定的源数组复制一个数组到目标数组的指定位置
        System.arraycopy(nums, 0, copy, 0, nums.length);
        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    /**
     * 功能描述: nums[left...right] 计算逆序对个数并排序
     * @Param: [nums, left, right, temp] 复制的数组， 左端点， 右端点， 空白数组
     * @Return: int
     * @Author: Blaife
     * @Date: 2020/4/24 11:33
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if(left == right) {
            return 0;
        }
        // mid 中间位置 两分
        int mid = left + ( right - left ) / 2;
        // 左边一半的逆序对个数
        int leftPairs = reversePairs(nums, left, mid, temp);
        // 右边一般的逆序对个数
        int rightPairs = reversePairs(nums, mid + 1, right, temp);
        // 判断左右两边合并在一起后是否有序， 有序则无需进行下一步的合并操作
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        // 合并左右两边，并得到此次合并时的逆序对
        int crossPairs = mergerAndCount(nums, left, mid, right, temp);

        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * 功能描述: nums[left...mid],nums[mid+1...right] 合并并计算逆序对个数
     * @Param: [nums, left, mid, right, temp] 复制的数组， 左端点， 中间点， 右端点， 空白数组
     * @Return: int
     * @Author: Blaife
     * @Date: 2020/4/24 11:59
     */
    private int mergerAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        // temp 用于暂时存储一节数据，
        if (right - left >= 0) {
            System.arraycopy(nums, left, temp, left, right - left + 1);
        }
        // 左半边指针
        int i = left;
        // 右半边指针
        int j = mid + 1;
        // 逆序对数量
        int count = 0;
        // 开始循环 left --> right
        for (int k = left; k <= right; k++) {
            // 左半边已执行结束
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            // 右半边执行完毕
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            // 左边小于等于右边，
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
            // 右边小于左边， 存在逆序对
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int x = new Solution().reversePairs(new int[]{7,5,6,4});
        System.out.println(x);
    }
}
