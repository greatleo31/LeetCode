package com.coder.binary_tree.flatten_binaryTree_to_linkedList_114;

public class Better {
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

  public void flatten(TreeNode root) {
    // 时间复杂度：O(n),空间复杂度：O(1)
    // 思路：原地展平节点

    if (root == null) {
      return;
    }

    // 先把左右子树展平
    flatten(root.left);
    flatten(root.right);

    // 保留右子树
    TreeNode tmp = root.right;

    // 移动左子树到右子树，并且置空左子树
    root.right = root.left;
    root.left = null;

    // 遍历到原左子树最后的节点连接到右子树
    TreeNode p = root;
    while (p.right != null) {
      p = p.right;
    }
    p.right = tmp;
  }
}
