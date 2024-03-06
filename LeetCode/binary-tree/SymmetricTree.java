import java.util.HashMap;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SymmetricTree {

    public boolean isSymmetricDouble(TreeNode left,TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right ==null) return false;

        return left.val == right.val  && isSymmetricDouble(left.left,right.right) && isSymmetricDouble(left.right,right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricDouble(root.left, root.right);
}
    
}

