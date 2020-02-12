package leetcode.t058lengthoflastword;

/**
 * """"""""""""""""""""""""""""""""""""""""""""""最后一个单词的长度""""""""""""""""""""""""""""""""""""""""""""""
 */
public class Solution {

    /**
     * 我们只需要找到最后一个单词前面的空格就可以了,循环遍历（正则可能会更加简单快速一点）
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int from = s.length()-1; // 起始点
        int left = s.lastIndexOf(" ", from);
        while (left == from){
            from--;
            left = s.lastIndexOf(" ", from);
            System.out.println(left);
            System.out.println(from);
        }
        int result = from-left;
        if (result < 0) {
            return 0;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("   "));
    }

}
