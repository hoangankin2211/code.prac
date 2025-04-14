import java.util.Objects;

public class LowestCommonAncestorOfBT2 {
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

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if (Objects.isNull(left) && Objects.isNull(right)){
            return null;
        }
        
        if (Objects.nonNull(left) && Objects.nonNull(right)){
            return root;
        }

        if (Objects.nonNull(left)){
            return left;
        }
        
        return right;
    }


    public static void main(String[] args) {
        // [3,5,1,6,2,0,8,null,null,7,4]

        var q = new TreeNode(4);
        var p = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), q));
        TreeNode treeNode = new TreeNode(3,
                p,
                new TreeNode(1, new TreeNode(0), new TreeNode(8)));

        System.out.println(new LowestCommonAncestorOfBT2().lowestCommonAncestor(treeNode, p, q).val);
    }
}
