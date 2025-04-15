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

class Solution1 {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return isBalanced(root.right) && isBalanced(root.left) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }   

    private int height(TreeNode root){
        if (root == null){
            return -1;
        }

        int left = height(root.left)+1;
        int right = height(root.right)+1;

        return left > right ? left : right;
    }
}


class Solution2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        return height(root) != -1;
    }

    private int height(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }

        return Math.max(left,right)+1;
    }
}