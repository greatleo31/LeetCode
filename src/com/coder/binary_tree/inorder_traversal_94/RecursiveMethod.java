package com.coder.binary_tree.inorder_traversal_94;

import java.util.ArrayList;
import java.util.List;

class RecursiveMethod {
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

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    inorder(root, list);
    return list;
  }

  public void inorder(TreeNode root, List<Integer> ans) {
    // 递归退出条件
    if (root == null) {
      return;
    }

    // 中序遍历
    inorder(root.left, ans);
    ans.add(root.val);
    inorder(root.right, ans);
  }
}
