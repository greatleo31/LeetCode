package com.coder.binary_tree.right_side_view_199;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Bfs {
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

  public List<Integer> rightSideView(TreeNode root) {
    // 时间复杂度：O(n), 空间复杂度：O(队列时间n)
    // bfs:结果集存右视图节点值，队列存遍历到的左右节点实现广搜

    // 初始化集合和队列
    Deque<TreeNode> queue = new LinkedList<>();
    List<Integer> ans = new ArrayList<>();
    // 边界处理
    if (root == null) {
      return ans;
    }
    queue.offer(root);

    // 循环遍历
    while (!queue.isEmpty()) {
      int count = queue.size();
      for (int i = 0; i < count; i++) {
        TreeNode tmp = queue.poll();
        if (tmp.left != null) {
          queue.offer(tmp.left);
        }
        if (tmp.right != null) {
          queue.offer(tmp.right);
        }
        if (i == count - 1) {
          ans.add(tmp.val);
        }
      }
    }
    return ans;
  }
}
