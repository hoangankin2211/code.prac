import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * https://leetcode.com/problems/path-sum-ii/description/
 *  
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
    Output: [[5,4,11,2],[5,8,4,5]]
    Explanation: There are two paths whose sum equals targetSum:
    5 + 4 + 11 + 2 = 22
    5 + 8 + 4 + 5 = 22
 */

public class PathSumII {
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return Collections.emptyList();
        }
        int currentTarget = targetSum - root.val;

        if (currentTarget == 0) {
            if (root.left == null && root.right == null) {
                return new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(root.val))));
            }
        }

        var left = pathSum(root.left, currentTarget);
        var right = pathSum(root.right, currentTarget);

        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> subList : left) {
            subList.add(0, root.val);
            result.add(subList);
        }

        for (List<Integer> subList : right) {
            subList.add(0, root.val);
            result.add(subList);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));

        System.out.println(new PathSumII().pathSum(new TreeNode(-2, null, new TreeNode(-3)), -5));
    }

    // public List<Integer> subPathSum(TreeNode root, int targetSum) {
    // if (root == null) {
    // if (targetSum == 0) {
    // return new ArrayList<>();
    // }
    // return null;
    // }
    // if (targetSum == 0) {
    // if (root.left != null || root.right != null) {
    // return null;
    // }
    // return Arrays.asList(root.val);
    // }

    // var left = subPathSum(root.left, targetSum);
    // var right = subPathSum(root.right, targetSum);

    // if (left != null)
    // }

    // final List<List<Integer>> result = new ArrayList<>();

    // return result;

    // }

}
