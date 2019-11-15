package leetcode.t319bulbswitcher;

/**
 * """""""""""""""""""""""""""""""""灯泡开关"""""""""""""""""""""""""""""""""
 * 题意：
 * 初始时有 n 个灯泡关闭。
 * 第 1 轮，你打开所有的灯泡。
 * 第 2 轮，每两个灯泡你关闭一次。
 * 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。
 * 第 i 轮，每 i 个灯泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关。
 * 找出 n 轮后有多少个亮着的灯泡。
 *
 * 示例:
 * 输入: 3
 * 输出: 1
 * 解释:
 * 初始时, 灯泡状态 [关闭, 关闭, 关闭].
 * 第一轮后, 灯泡状态 [开启, 开启, 开启].
 * 第二轮后, 灯泡状态 [开启, 关闭, 开启].
 * 第三轮后, 灯泡状态 [开启, 关闭, 关闭].
 *
 * 你应该返回 1，因为只有一个灯泡还亮着。
 *
 */
public class Solution {
    /**
     * Math函数运行速度快
     * delegates to StrictMath Note that hardware sqrt instructions frequently can be directly used by JITs
     * and should be much faster than doing Math.sqrt in software.
     * StrictMath的代表注意到，硬件sqrt指令通常可以直接由JIT使用，并且应该比在软件中执行Math.sqrt快得多。
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }

    /**
     * 数学逻辑运行  速度慢，会超时
     * @param n
     * @return
     */
    public int bulbSwitch2(int n) {
        int brightNumber = 0;
        for (int i = 1; i <= n; i++) {
            if (exactDivisionAmount(i)%2 == 1) {
                brightNumber ++;
            }
        }
        return brightNumber;
    }

    /**
     * 判断一个数可整除的数有多少个
     * @param number
     * @return
     */
    public int exactDivisionAmount(int number) {
        int amount = 0;
        for (int i = 1; i <= number; i++) {
            if (number%i == 0) {
                amount ++;
            }
        }
        return amount;
    }

    public static void main(String[] args) {
        int x = new Solution().bulbSwitch(99999);
        System.out.println(x);
    }
}
