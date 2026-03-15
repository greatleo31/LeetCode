package com.coder.linkedlist.merge_K_sorted_lists_23;

class Normal {
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    // 时间复杂度：O(k²*n)，空间复杂度：O(1)
    // 思路：先局部解决：创建方法解决两个升序链表合并成一个升序链表，整体上遍历链表数组逐个合并

    ListNode ans = null;
    for (int i = 0; i < lists.length; i++) {
      ans = mergeTwoLinkedList(ans, lists[i]);
    }
    return ans;
  }

  // 合并两个升序链表
  public ListNode mergeTwoLinkedList(ListNode a, ListNode b) {
    // 边界处理
    if (a == null || b == null) {
      return (a == null) ? b : a;
    }

    // 初始化
    ListNode head = new ListNode(-1);
    ListNode tail = head;
    while (a != null && b != null) {
      if (a.val <= b.val) {
        tail.next = a;
        a = a.next;
      } else {
        tail.next = b;
        b = b.next;
      }
      tail = tail.next;
    }
    tail.next = (a == null) ? b : a;

    return head.next;
  }

}
