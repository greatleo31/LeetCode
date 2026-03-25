package com.coder.binary_tree.right_side_view_199;

import java.util.ArrayList;
import java.util.List;

public class Dfs {
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

  List<Integer> list = new ArrayList<>();

  public List<Integer> rightSideView(TreeNode root) {
    // 时间复杂度：O(n), 空间复杂度：O(递归栈n)
    // dfs:递归顺序--根，右，左即可

    dfs(root, 1);
    return list;
  }

  public void dfs(TreeNode root, int level) {
    if (root == null) {
      return;
    }
    if (list.size() < level) {
      list.add(root.val);
    }
    dfs(root.right, level + 1);
    dfs(root.left, level + 1);
  }
}
