package leetcode.theswordreferstooffer.t69peaksinthearray;

/**
 * @Description: 山峰数组
 *
 * 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
 *
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。
 *
 * @Author: magd39318
 * @Date: 2021/10/14 9:35
 */
public class Solution {

    public int peakIndexInMountainArray(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return i - 1;
            }
            if (arr[arr.length - i - 1] < arr[arr.length - i]) {
                return arr.length - i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{24,69,100,99,79,78,67,36,26,19};

        System.out.println(solution.peakIndexInMountainArray(arr));
    }

}
