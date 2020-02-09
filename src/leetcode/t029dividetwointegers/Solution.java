package leetcode.t029dividetwointegers;

/**
 * """""""""""""""""""""""""""""""""""""""""""""两数相除"""""""""""""""""""""""""""""""""""""""""""""
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 *
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 *
 * 说明:
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class Solution {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) {
                return -dividend;// 只要不是最小的那个整数，都是直接返回相反数就好啦
            }
            return Integer.MAX_VALUE;// 是最小的那个，那就返回最大的整数啦
        }

        long a = dividend; // 被chushu
        long b = divisor; // 除数
        int sign = 1;
        if((a > 0 && b < 0) || (a < 0 && b > 0)){ // 对两值进行正负判断
            sign = -1;
        }
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b; // 两边控制到符号相同
        long res = div(a, b);
        if(sign > 0) {
            return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
        }
        return (int) -res;
    }


    /**
     * 精髓和难点就在于下面这几句
     * @param a 被除数
     * @param b 除数
     * @return
     */
    public static int div(long a, long b){
        if(a < b) {
            return 0;
        }
        long count = 1; // 倍数 即为返回值
        long tb = b; // 在后面的代码中不更新b
        while((tb + tb) <= a){
            count = count + count; // 最小解翻倍
            tb = tb + tb; // 当前测试的值也翻倍
        }
        return (int) (count + div(a - tb, b)); // 递给算法，指数增加，直到为0
    }


    public static void main(String[] args) {
        System.out.println(new Solution().divide(50, 8));
    }
}
