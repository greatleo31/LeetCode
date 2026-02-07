package com.coder.linkedlist.linked_list_cycle_141;

public class Better {
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

  public boolean hasCycle(ListNode head) {
    // 快慢指针：若存在环，则快指针一定会套圈
    // 时间复杂度O(N),空间复杂度O(1)

    // 边界处理
    if (head == null || head.next == null) {
      return false;
    }

    // 创建快慢指针
    ListNode slow = head;
    ListNode fast = head.next;
    // 遍历
    while (fast != slow) {
      if (fast == null || fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return true;
  }
}
