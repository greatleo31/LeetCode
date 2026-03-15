package com.coder.linkedlist.remove_Nth_node_fromTheEndLinked_19;

import java.util.Deque;
import java.util.LinkedList;

class OneIteratorAndStack {
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

  public ListNode removeNthFromEnd(ListNode head, int n) {
    // 时间复杂度：O(n),空间复杂度：O(1)。只扫描一趟
    // 核心思路：通过栈FILO得到目标节点前置节点的位置,再单独删除

    // 创建首节点
    ListNode ans = new ListNode(-1, head);
    // 创建栈(官方推荐deq实现)
    Deque<ListNode> stack = new LinkedList<>();

    // 入栈
    ListNode p = ans;
    while (p != null) {
      stack.push(p);
      p = p.next;
    }
    // 根据n出栈
    for (int i = 0; i < n; i++) {
      stack.pop();
    }
    p = stack.peek(); // peek（）获取栈顶元素
    // 删除节点
    p.next = p.next.next;
    return ans.next;

  }
}
