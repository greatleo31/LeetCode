package com.coder.binary_tree.build_binarytree_from_preorder_and_inorder_105;

import java.util.HashMap;

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

  HashMap<Integer, Integer> map = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    // 时间复杂度：O（n），空间复杂度：O（n）
    // 思路：先根据先序遍历找到根节点，在中序遍历的序列确认根节点的位置，最后根据两个序列的边界位置递归创建左右子树，在连接到根节点即可
    // 细节：在中序遍历列表找根节点时可以根据HashMap以O（n）时间复杂度找到元素

    // 循环创建map
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return myBuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
  }

  /**
   * 新建左右子树
   */
  public TreeNode myBuildTree(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
    // 递归终止条件
    if (pre_left > pre_right) {
      return null;
    }
    int pre_root = pre_left;
    int in_root = map.get(preorder[pre_root]);
    TreeNode root = new TreeNode(preorder[pre_root]);
    // 得到左子树的节点数目
    int left_subTree_size = in_root - in_left;
    // 递归构建左子树
    root.left = myBuildTree(preorder, inorder, pre_left + 1, pre_left + left_subTree_size, in_left, in_root - 1);
    // 递归构建右子树
    root.right = myBuildTree(preorder, inorder, pre_left + left_subTree_size + 1, pre_right, in_root + 1, in_right);
    return root;
  }
}
