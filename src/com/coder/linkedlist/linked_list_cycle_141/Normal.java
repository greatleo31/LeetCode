package com.coder.linkedlist.linked_list_cycle_141;

import java.util.HashSet;
import java.util.Set;

public class Normal {

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
    // 隐含条件：节点地址不能重复，值可以重复
    // 时间复杂度O(N),空间复杂度O(N)

    // 创建哈希表
    Set<ListNode> set = new HashSet<>();
    // 遍历
    while (head != null) {
      if (set.contains(head))
        return true;
      set.add(head);
      head = head.next;
    }
    return false;
  }
}