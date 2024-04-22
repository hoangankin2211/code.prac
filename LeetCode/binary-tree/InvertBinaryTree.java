import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        printTree(root);
        root = invertTree2(root);
        System.out.println();
        printTree(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queueTree = new LinkedList<>();
        queueTree.add(root);

        while (!queueTree.isEmpty()) {
            TreeNode temp = queueTree.poll();
            swapNode(temp);

            if (temp.right != null) {
                queueTree.add(temp.right);
            }

            if (temp.left != null) {
                queueTree.add(temp.left);
            }
        }

        return root;
    }

    private static void swapNode(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void printTree(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queueTree = new LinkedList<>();
        queueTree.add(root);
        while (!queueTree.isEmpty()) {
            TreeNode temp = queueTree.poll();
            if (temp.left != null) {
                queueTree.add(temp.left);
            }
            if (temp.right != null) {
                queueTree.add(temp.right);
            }

            System.out.print(temp.val);
        }
    }

    public static TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return null;
        TreeNode result = new TreeNode(root.val);
        result.left = invertTree2(root.right);
        result.right = invertTree2(root.left);

        return result;
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