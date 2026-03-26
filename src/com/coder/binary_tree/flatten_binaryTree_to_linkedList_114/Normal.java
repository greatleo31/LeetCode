package com.coder.binary_tree.flatten_binaryTree_to_linkedList_114;

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

  TreeNode tail = new TreeNode(); // 全局尾指针

  public void flatten(TreeNode root) {
    // 时间复杂度：O(n),空间复杂度：O(n=保留的左右节点)

    if (root == null) {
      return;
    }

    // 先保存左右子树，因为后面会被修改
    TreeNode left = root.left;
    TreeNode right = root.right;

    // 核心：把当前节点接到链表尾部
    tail.right = root;
    tail = tail.right;

    // 关键！必须把左孩子置空
    tail.left = null;

    // 先序遍历：左 → 右
    flatten(left);
    flatten(right);
  }
}
