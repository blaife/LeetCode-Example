package leetcode.t025reversenodesinkgroup;

/**
 * @author Blaife
 * @description 25 - K个一组翻转链表
 * @data 2020/5/16 10:51
 * 题意：
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明：
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 通过次数57,112提交次数96,816
 *
 */
public class Solution {
    /**
     * 分组进行翻转 --> 已翻转部分+待翻转部分+未翻转部分
     * @param head 链表头
     * @param k 每组数量
     * @return 翻转后的链表
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 新建链表
        ListNode dummy = new ListNode(0);
        // 赋予下一位置引用
        dummy.next = head;

        // 当前处理组的初始位置
        ListNode pre = dummy;
        // 当前处理组的结束位置
        ListNode end = dummy;

        // 循环判断
        while (end.next != null) {
            // 循环，将end传递到指定位置
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 为null，说明当前数量不足， 直接停止循环
            if (end == null) {
                break;
            }
            // 当前组的第一个节点
            ListNode start = pre.next;
            // 下一组的第一个节点
            ListNode next = end.next;

            // 当前组尾结点next清空 便于reverse方法进行翻转
            end.next = null;
            // 反转
            pre.next = reverse(start);
            // 现在start节点已经是当前组的尾节点了， 让它与后面的部分进行链接
            start.next = next;
            // 更新当前处理的头节点
            pre = start;
            // 更新当前处理的尾节点
            end = pre;
        }
        return dummy.next;
    }

    /**
     * 对一个组内的数据进行翻转
     * @param head 当前处理组的头节点
     * @return 反转后的链表
     */
    private ListNode reverse(ListNode head) {
        // 新建节点 用于存储数据
        ListNode pre = null;
        // 当前节点
        ListNode curr = head;
        // 循环 -- 进行翻转
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
