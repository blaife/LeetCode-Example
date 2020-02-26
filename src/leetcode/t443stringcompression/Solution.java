package leetcode.t443stringcompression;

/**
 * """"""""""""""""""""""""""""""""""""""""""""""""""""压缩字符串""""""""""""""""""""""""""""""""""""""""""""""""""""
 *
 * 题意：
 * 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 *
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 *
 * 示例 1：
 * 输入：
 * ["a","a","b","b","c","c","c"]
 * 输出：
 * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
 * 说明：
 * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
 *
 * 示例 2：
 * 输入：
 * ["a"]
 * 输出：
 * 返回1，输入数组的前1个字符应该是：["a"]
 * 说明：
 * 没有任何字符串被替代。
 *
 * 示例 3：
 * 输入：
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：
 * 返回4，输入数组的前4个字符应该是：["a","b","1","2"]。
 *
 * 说明：
 * 由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。
 * 注意每个数字在数组中都有它自己的位置。
 *
 * 注意：
 * 所有字符都有一个ASCII值在[35, 126]区间内。
 * 1 <= len(chars) <= 1000。
 *
 */
public class Solution {

    public int compress(char[] chars) {
        // 读的字符起始位置与写的位置
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            // 下一位字符与当前为字符不一致或已经到达末尾
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                // 字符放入指定位置
                chars[write++] = chars[anchor];
                if (read > anchor) { // 此项成立说明相同字符数量大于0
                    // ("" + (read - anchor + 1)).toCharArray() 得到当前字符数量的char数组
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                // 修改停泊值 即当前判断数量的字符的起始位置
                anchor = read + 1;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compress(new char[]{'a', 'd', 'g', 'd', 'd', 'd'}));
    }

}
