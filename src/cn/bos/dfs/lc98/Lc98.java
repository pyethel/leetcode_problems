package cn.bos.dfs.lc98;

import java.util.ArrayList;
import java.util.List;

/**
 * @classname: Lc98
 * @description: default
 * @author: pyethel
 * @create: 2021/12/1 09:56
 */
public class Lc98 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        TreeNode node1 = root.right;
        node1.left = new TreeNode(3);
        node1.right = new TreeNode(6);
        boolean validBST = solution.isValidBST(root);
        System.out.println(validBST);

        Solution solution1 = new Solution();
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        boolean validBST1 = solution1.isValidBST(root1);
        System.out.println(validBST1);
    }
}

class Solution {
    private final List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        preOrder(root);
        System.out.println(list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        list.add(node.val);
        preOrder(node.right);
    }
}

class TreeNode {
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