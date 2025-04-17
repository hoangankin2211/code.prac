import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
 */

public class BinaryTreeZigzagTraversal {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        LinkedList<TreeNode> ll = new LinkedList<>();
        ll.add(root);

        boolean l2r = true;
        while (!ll.isEmpty()) {
            int count = 0;
            int length = ll.size();
            List<Integer> nodeTraverse = new ArrayList<>();
            while (count < length) {
                TreeNode node = null;
                if (l2r) {
                    node = ll.removeFirst();
                    if (node.left != null) {
                        ll.addLast(node.left);
                    }
                    if (node.right != null) {
                        ll.addLast(node.right);
                    }
                } else {
                    node = ll.removeLast();
                    if (node.right != null) {
                        ll.addFirst(node.right);
                    }
                    if (node.left != null) {
                        ll.addFirst(node.left);
                    }
                }
                nodeTraverse.add(node.val);
                count++;
            }
            result.add(nodeTraverse);
            l2r = !l2r;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeZigzagTraversal().zigzagLevelOrder(
                new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(new BinaryTreeZigzagTraversal().zigzagLevelOrder(
                new TreeNode(1)));

        // [1,2,3,4,null,null,5]
        System.out.println(new BinaryTreeZigzagTraversal().zigzagLevelOrder(
                new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)))));

    }

}
