package cn.bos.lc563;

/**
 * @classname: TreeNode
 * @description: default
 * @author: pyethel
 * @create: 2021/11/18 14:08
 */
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        int tilt = solution.findTilt(treeNode1);
        System.out.println(tilt);
    }
}

class Solution {
    private int totalTilt;

    public int findTilt(TreeNode root) {
        buildSum(root);
        addTilt(root);
        return totalTilt;
    }

    private void addTilt(TreeNode root) {
        if (root == null) {
            return;
        }
        int leftSum = 0, rightSum = 0;
        if (root.left != null) {
            leftSum = root.left.val;
        }
        if (root.right != null) {
            rightSum = root.right.val;
        }
        int tilt = Math.abs(leftSum - rightSum);
        totalTilt += tilt;
        addTilt(root.left);
        addTilt(root.right);
    }

    private int buildSum(TreeNode root) {
        int leftSum, rightSum;
        if (root == null) {
            return 0;
        }
        leftSum = buildSum(root.left);
        rightSum = buildSum(root.right);
        root.val += leftSum + rightSum;
        return root.val;
    }
}