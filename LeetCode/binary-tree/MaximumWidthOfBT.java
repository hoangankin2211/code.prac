import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
* https://leetcode.com/problems/maximum-width-of-binary-tree/description/ 

* Given the root of a binary tree, return the maximum width of the given tree.
The maximum width of a tree is the maximum width among all levels.
The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), 
where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
It is guaranteed that the answer will in the range of a 32-bit signed integer.

Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

Topic
- Tree
- Depth-First Search
- Breadth-First Search
- Binary Tree
*/

public class MaximumWidthOfBT {
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

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int result = 0;
        while (!queue.isEmpty()) {
            int count = 0;
            int length = queue.size();

            while (count < length) {
                count++;
                TreeNode node = queue.poll();
                
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        
        return result;
    }

    // [1,3,2,5,null,null,9,6,null,7]
    public static void main(String[] args) {
        System.out.println(new MaximumWidthOfBT()
                .widthOfBinaryTree(new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)),
                        new TreeNode(2, null, new TreeNode(9)))));
        System.out.println(new MaximumWidthOfBT()
                .widthOfBinaryTree(new TreeNode(1, new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null),
                        new TreeNode(2, null, new TreeNode(9, new TreeNode(7), null)))));

    }
}
