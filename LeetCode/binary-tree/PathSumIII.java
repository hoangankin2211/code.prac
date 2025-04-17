/*
https://leetcode.com/problems/path-sum-iii/description/

 * 437. Path Sum III
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.

*/

import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PathSumIII {
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

    public static void main(String[] arsg) {
        /*
         * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
         */
        // System.out
        // .println(
        // new PathSumIII().pathSum(new TreeNode(10,
        // new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)),
        // new TreeNode(2, null, new TreeNode(1))),
        // new TreeNode(-3, null, new TreeNode(11))), 8));
        /*
         * Input: root = [1,-2,-3,1,3,-2,null,-1], targetSum = -1
         * Output: 3
         */
        System.out.println(new PathSumIII().pathSum(buildTree(new Integer[] { 1, -2, -3, 1, 3, -2, null, -1 }), -1));
        /*
         * Input: root = [-1], targetSum = -1
         * Output: 1
         */
        System.out.println(new PathSumIII().pathSum(new TreeNode(-1), -1));

        /*
         * Input: root =
         * [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,
         * 1000000000], targetSum = 0
         * Output: 0
         */
        System.out.println(new PathSumIII().pathSum(buildTree(new Integer[] { 1000000000, 1000000000, null, 294967296,
                null, 1000000000, null, 1000000000, null, 1000000000 }), 0));
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        
        return pathSumII(root,targetSum);
    }

    public int pathSumII(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        long currentTarget = targetSum - root.val;
        int count = 0;
        if (currentTarget == 0) {
            count = 1;
        }

        var left = pathSumII(root.left, currentTarget);
        var right = pathSumII(root.right, currentTarget);

        return count + left + right;
    }

    public static TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < values.length) {
            TreeNode current = queue.poll();

            // Assign left child
            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;

            // Assign right child
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

}