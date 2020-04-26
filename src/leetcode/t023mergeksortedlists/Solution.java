package leetcode.t023mergeksortedlists;

import java.util.*;

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
     * 队列排序取顶节点
     * @param lists 排序链表数组
     * @return 排序后链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) {
            return null;
        }
        //创建一个小根堆，并定义好排序函数
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val - o2.val);
            }
        });
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        //这里跟上一版不一样，不再是一股脑全部放到堆中
        //而是只把k个链表的第一个节点放入到堆中
        for(int i=0;i<lists.length;i++) {
            ListNode head = lists[i];
            if(head!=null) {
                queue.add(head);
            }
        }
        //之后不断从堆中取出节点，如果这个节点还有下一个节点，
        //就将下个节点也放入堆中
        while(queue.size()>0) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if(node.next!=null) {
                queue.add(node.next);
            }
        }
        cur.next = null;
        return dummy.next;
    }

    /**
     * 骚气的暴力法 -- 先排序取出值存入Arraylist，然后排序后再更换回链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode resListNode = new ListNode(0);
        // 这个可以理解为一个指针 他和resList指向的是同一个堆中的数据
        ListNode pointer = resListNode;
        if (lists.length <= 0) {
            return resListNode.next;
        }
        // 放入List集合
        List<Integer> l = new ArrayList<>();
        for (ListNode ln : lists) {
            while (ln != null) {
                l.add(ln.val);
                ln = ln.next;
            }
        }
        // 排序list集合后再转为ListNode
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
