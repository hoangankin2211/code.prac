import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

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

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newTree = new TreeNode(root.val);
        newTree.left = invertTree(root.right);
        newTree.right = invertTree(root.left);
        return newTree;
    }
    //     TreeNode newTree = null;
    //     TreeNode cur = null;
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.add(root);    

    //     while (!queue.isEmpty()){
    //         TreeNode node = queue.poll();
            
    //     }

    //     return null;
    // }
}