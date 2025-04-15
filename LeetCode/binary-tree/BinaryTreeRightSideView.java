import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeRightSideView {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Stack<TreeNode> stack = new Stack<>();
        while (!queue.isEmpty()) {
            int count = 0;
            int length = queue.size();
            boolean isFinalLevel = true;
            while (true) {
                if (count == length)
                    break;
                count++;

                TreeNode node = queue.poll();

                if (Objects.nonNull(node.left)) {
                    queue.add(node.left);
                    stack.add(node.left);
                    isFinalLevel = false;
                }

                if (Objects.nonNull(node.right)) {
                    queue.add(node.right);
                    stack.add(node.right);
                    isFinalLevel = false;
                }
            }
            if (!isFinalLevel) {
                result.add(stack.pop().val);
                stack.clear();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        var q = new TreeNode(4);
        var p = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), q));
        TreeNode treeNode = new TreeNode(3,
                p,
                new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        System.out.println(new BinaryTreeRightSideView().rightSideView(treeNode));
    }
}
