package com.coder.linkedlist.reverse_nodes_in_kGroup_25;

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

  public ListNode reverseKGroup(ListNode head, int k) {
    // 时间复杂度：O(n)，空间复杂度：O(1)
    // 核心：递归，先确定递归终止条件，在确定递归逻辑

    // 递归终止条件
    ListNode cur = head;
    for (int i = 0; i < k; i++) {
      if (cur == null) {
        return head;
      }
      cur = cur.next;
    }
    // 获取下一个递归的头节点
    ListNode firstOtherNode = reverseKGroup(cur, k);
    ListNode pre = firstOtherNode;

    // 翻转
    for (int i = 0; i < k; i++) {
      ListNode tmp = head.next;
      head.next = pre;
      pre = head;
      head = tmp;
    }
    return pre;
  }
}
