package com.coder.linkedlist.linked_list_cycle_142;

public class Better {
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode detectCycle(ListNode head) {
    // 时间复杂度：O(n)，空间复杂度O(1)
    // 核心思路：追及问题，当速度快的一方和慢的一方相遇说明存在环

    // 边界处理,小心访问null的next
    if (head == null) {
      return null;
    }
    // 起点要相同符合追及问题模型
    ListNode slow = head;
    ListNode fast = head;
    // 遍历判断,小心访问null的next
    while (fast != null && fast.next != null) {
      // 先移动，因为初始化一样
      slow = slow.next;
      if (fast.next != null) {
        fast = fast.next.next;
      } else {
        return null;
      }
      // 判断
      if (fast == slow) {
        // 此时说明存在环，但是要确定环出现的节点（数学推导）
        ListNode ptr = head;
        while (ptr != slow) {
          ptr = ptr.next;
          slow = slow.next;
        }
        return ptr;
      }
    }
    return null;
  }
}
