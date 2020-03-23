package leetcode.t024swapnodesinpairs;

/**
 * """""""""""""""""""""""""""""""""""""""""""""""""两两交换链表中的节点"""""""""""""""""""""""""""""""""""""""""""""""""
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    /**
     * 递归算法：
     * 如链表为1234. 则每次调用swapPairs方法都是从当前位置向后推移两位，即34.将其旋转后返回
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}

