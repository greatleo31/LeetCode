package com.coder.binary_tree.level_order_traversal_102;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    // 时间复杂度：O(n)，空间复杂度：O(1)
    // 思路：广度优先搜索最优搭配：队列+内部循环
    // 根据队列的长度作为循环次数，将一层完整的节点存入队列，此时同一层添加进结果list

    // 初始化队列
    Deque<TreeNode> queue = new LinkedList<>();
    // 结果list
    List<List<Integer>> res = new ArrayList<>();
    // 边界处理
    if (root == null) {
      return res;
    }
    queue.offer(root);
    while (!queue.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      int size = queue.size();
      for (int i = 1; i <= size; i++) {
        TreeNode node = queue.poll();
        list.add(node.val);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      res.add(list);
    }
    return res;

  }
}
