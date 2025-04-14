import java.util.Objects;

public class LowestCommonAncestorOfBT {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (Objects.isNull(root))
            return null;

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode aP = findNode(root.left, p);
        TreeNode qP = findNode(root.right, q);

        if ((Objects.isNull(aP) && Objects.isNull(qP)) || (Objects.nonNull(aP) && Objects.nonNull(qP)))
            return root;

        if (Objects.isNull(aP))
            return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }

    public TreeNode findNode(TreeNode root, TreeNode node) {
        if (Objects.isNull(root))
            return null;
        if (root.val == node.val)
            return root;
        var left = findNode(root.left, node);
        if (Objects.nonNull(left))
            return left;
        var right = findNode(root.right, node);
        return right;
    }

    public static void main(String[] args) {
        // [3,5,1,6,2,0,8,null,null,7,4]

        var q = new TreeNode(4);
        var p = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), q));
        TreeNode treeNode = new TreeNode(3,
                p,
                new TreeNode(1, new TreeNode(0), new TreeNode(8)));

        System.out.println(new LowestCommonAncestorOfBT().lowestCommonAncestor(treeNode, p, q));
    }
}
