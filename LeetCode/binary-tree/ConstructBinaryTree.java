
/*
Construct Binary Tree from Preorder and Inorder Traversal

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
    3
9   
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class ConstructBinaryTree {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

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

    void bFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (Objects.nonNull(node.left)) {
                queue.add(node.left);
            }
            if (Objects.nonNull(node.right)) {
                queue.add(node.right);
            }
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        return solve(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode solve(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pEnd - pStart + 1 == 0) {
            return null;
        }
        if (pEnd - pStart + 1 == 0)
            return new TreeNode(preorder[pStart]);

        int pos = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[pStart]) {
                pos = i;
                break;
            }
        }

        TreeNode root = new TreeNode(preorder[pStart]);

        root.left = solve(preorder, 1, pos + 1, inorder, 0, pos);
        root.right = solve(preorder, pos + 1, pEnd - pStart + 1, inorder, pos + 1, iEnd - iStart + 1);

        return root;
    }

    public static void main(String[] args) {
        new ConstructBinaryTree()
                .bFS(new ConstructBinaryTree().buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 }));
    }
}
