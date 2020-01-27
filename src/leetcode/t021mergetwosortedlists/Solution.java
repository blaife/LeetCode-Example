package leetcode.t021mergetwosortedlists;

/**
 * """"""""""""""""""""""""""""""""""""""""""""合并两个有序链表""""""""""""""""""""""""""""""""""""""""""""
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */
public class Solution {

    /**
     * 思路：需要排序则一定需要比较大小 比较大小并向后移位 当其中一个为空时 将另一个链表的剩余部分加入后面
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0); // 设置返回值，这一步就确定了堆的信息
        ListNode pointer = l3; // 这个可以理解为一个指针 他和l3指向的是同一个堆中的数据
        // 循环比较，直到其中一个链表移位到空
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pointer.next = l2; // 修改返回值堆中信息
                pointer = pointer.next; // 指针移位
                l2 = l2.next; // 此数据一消耗，向后移位
            } else {
                pointer.next = l1;
                pointer = pointer.next;
                l1 = l1.next;
            }
        }
        // 其实已经考虑了初始链表为空的情况 （且初始）
        // 1. l1 为空 l2 不为空  l3 == l2
        // 2. l2 为空 l1 不为空  l3 == l1
        // 3. l1 为空 l2 也是空  l3 == l2 == 空
        if (l1 != null) { // l1不为空，则将l1的剩余部分接到后面
            pointer.next = l1;
        } else { // 否则将l2的剩余部分接到后面
            pointer.next = l2;
        }
        return l3.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new Solution().mergeTwoLists(l1, l2);
        while (l3 != null) {
            System.out.print(l3.val);
            l3 = l3.next;
        }
    }

}
