package com.coder.binary_tree.diameter_binary_tree_543;

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

  int ans = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return ans - 1;
  }

  public int depth(TreeNode node) {
    // 递归终止条件
    if (node == null) {
      return 0;
    }
    int L = depth(node.left); // 左儿子为根的子树的深度
    int R = depth(node.right); // 右儿子为根的子树的深度
    ans = Math.max(ans, L + R + 1); // 计算d_node即L+R+1 并更新ans
    return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
  }
}
