package leetcode.t466counttherepetitions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Blaife
 * @description 466 - 统计重复的个数
 * @data 2020/4/19 19:57
 * 题意：
 * 由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。
 * 如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。
 * 例如，根据定义，"abc" 可以从 “abdbec” 获得，但不能从 “acbbe” 获得。
 * 现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。
 * 现在考虑字符串 S1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。
 * 请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。
 *
 * 示例：
 * 输入：
 * s1 ="acb",n1 = 4
 * s2 ="ab",n2 = 2
 * 返回：
 * 2
 */
public class Solution {
    /**
     * 功能描述: 获得循环节
     * @author: Blaife
     * @date: 2020/4/19 20:43
     * @param s1 S1 字符串
     * @param n1 s1 字符串循环次数
     * @param s2 S2 字符串
     * @param n2 s2 字符串循环次数
     * @return: int
     */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length();
        int len2 = s2.length();
        // 特判
        if (len1 == 0 || len2 == 0 || n1 == 0 || n2 == 0) {
            return 0;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        // 经历的s1的次数
        int count1 = 0;
        // 经历的s2的次数
        int count2 = 0;
        // 当前指向的s2中的位置
        int p = 0;
        // 记录每一次s1扫描结束后所在s2中的位置，寻找循环规律
        Map<Integer, int[]> mp = new HashMap<>();

        while (count1 < n1) {
            for (int i = 0; i < len1; i++) {
                if (chars1[i] == chars2[p]) {
                    p++;
                    if (p == len2) {
                        p = 0;
                        count2++;
                    }
                }
            }
            count1 ++;
            if (!mp.containsKey(p)) {
                mp.put(p, new int[]{count1, count2});
            } else {
                int[] last = mp.get(p);
                // 获取每次循环所消耗的s1和s2的个数
                int circle1 = count1 - last[0];
                int circle2 = count2 - last[1];
                // 获取到下一个循环点的s2的总循环次数
                count2 += circle2 * ((n1 - count1) / circle1);
                // 获取到下一个循环点的s1的总循环次数
                count1 += circle1 * ((n1 - count1) / circle1);
                // 执行到这里后如果S1没有循环完， 则将后续的继续循环完。
            }
        }
        // s1 执行完成后， s2的执行总次数 / s2的拥有次数 == 可循环次数
        return  count2 / n2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMaxRepetitions("abcabcabc", 20, "abcabc", 10));
    }
}
