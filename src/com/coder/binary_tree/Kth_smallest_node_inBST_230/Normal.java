package com.coder.binary_tree.Kth_smallest_node_inBST_230;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Normal {
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

  public List<Integer> inorder(List<Integer> list, TreeNode root) {
    // 中序遍历
    if (root == null) {
      return null;
    }
    inorder(list, root.left);
    list.add(root.val);
    inorder(list, root.right);
    return list;
  }

  public int kthSmallest(TreeNode root, int k) {
    // 时间复杂度：O(n+N),空间复杂度：O(n)
    // 思路：中序遍历利用栈先压入所有左节点，在回溯所有右节点，同时k--，找到目标节点，输出该值
    Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      --k;
      if (k == 0) {
        break;
      }
      root = root.right;
    }
    return root.val;
  }
}
