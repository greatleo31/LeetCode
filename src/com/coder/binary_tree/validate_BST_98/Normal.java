package com.coder.binary_tree.validate_BST_98;

import java.util.ArrayList;
import java.util.List;

class Normal {
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

  public boolean isValidBST(TreeNode root) {
    // 时间复杂度：O(n),空间复杂度：O(n)
    // 思路：二叉搜索树的中序遍历一定是升序序列，遍历后循环判断即可

    // 初始化list
    List<Integer> list = new ArrayList<>();
    list = inorder(list, root);
    for (int i = 0; i < list.size() - 1; i++) {
      if (list.get(i) >= list.get(i + 1)) {
        return false;
      }
    }
    return true;
  }
}