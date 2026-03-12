package com.coder.linkedlist.copy_list_with_random_pointer_138;

import java.util.HashMap;

class Normal {
  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  public Node copyRandomList(Node head) {
    // 时间复杂度：O(n),空间复杂度：O(n)
    // 思路：用哈希表一一对应创建原链表的各个节点，再循环将next和random节点一一指向。而不是边遍历边创建，此时random的节点可能还没创建

    // 创建哈希表
    HashMap<Node, Node> map = new HashMap<>();
    // 创建新链表独立的节点
    Node p = head;
    while (p != null) {
      map.put(p, new Node(p.val));
      p = p.next;
    }
    // 遍历建立next和random
    p = head;
    while (p != null) {
      map.get(p).next = map.get(p.next);
      map.get(p).random = map.get(p.random);
      p = p.next;
    }
    return map.get(head);
  }
}
