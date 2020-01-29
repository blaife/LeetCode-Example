package leetcode.t023mergeksortedlists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * """""""""""""""""""""""""""""""""""""""""""合并K个排序链表"""""""""""""""""""""""""""""""""""""""""""
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Solution {

    /**
     * 21题是合并两个排序链表
     * 两个和多个 我们如何将其全部取出，并迭代
     * 超时了
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode resList = new ListNode(-1); // 设置返回值，这一步就确定了堆的信息
        ListNode pointer = resList; // 这个可以理解为一个指针 他和resList指向的是同一个堆中的数据
        if (lists.length <= 0) {
            return resList.next;
        }
        while (true) {
            ListNode paraList = new ListNode(-1);
            int remainListNumber = 0;
            int selectNumber = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (paraList.val == -1 || paraList.val > lists[i].val) {
                        paraList = lists[i];
                        selectNumber = i;
                    }
                    remainListNumber ++;
                }
            }
            if (paraList.val != -1) {
                pointer.next = paraList;
                pointer = pointer.next;
                lists[selectNumber] = lists[selectNumber].next;
            }
            if (remainListNumber <= 1) {
                return resList.next;
            }
        }
    }

    /**
     * 骚气的暴力法 -- 先排序取出值存入Arraylist，然后排序后再更换回链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode resListNode = new ListNode(0);
        ListNode pointer = resListNode; // 这个可以理解为一个指针 他和resList指向的是同一个堆中的数据
        if (lists.length <= 0) {
            return resListNode.next;
        }
        List<Integer> l = new ArrayList<>();
        for (ListNode ln : lists) {
            while (ln != null) {
                l.add(ln.val);
                ln = ln.next;
            }
        }
        if (l.size() > 0){
            Object[] array = l.toArray();
            Arrays.sort(array);
            for (Object i : array) {
                pointer.next = new ListNode((int)i);
                pointer = pointer.next;
            }
        }
        return resListNode.next;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{l1, l2, l3};
        ListNode res = new Solution().mergeKLists2(lists);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }

}
