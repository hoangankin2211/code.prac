import java.util.ArrayList;
import java.util.List;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode(int x) {
            val = x;
        }
    }
    private List<TreeNode> findPath(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return new ArrayList<>();
        }

        List<TreeNode> result = new ArrayList<>();
        TreeNode temp = root;

        while (temp != null && temp.val != p.val) {
            result.add(temp);
            if (temp.val > p.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        if (temp != null) {
            result.add(p);
            return result;
        }

        return new ArrayList<>();
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;

        if (p == root || q == root) {
            return root;
        }

        List<TreeNode> pathP = findPath(root, p);
        List<TreeNode> pathQ = findPath(root, q);

        TreeNode result = root;
        int length = Math.min(pathP.size(), pathQ.size());

        for (int i = 1; i < length; i++) {
            if (pathP.get(i) == pathQ.get(i)) {
                result = pathP.get(i);
            } else {
                return result;
            }
        }

        return result;
    }

    public static void main(String[] args){

        new Solution().lowestCommonAncestor(new TreeNode(1), new TreeNode(2), new TreeNode(3));
    }
}

class Solution2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode(int x) {
            val = x;
        }
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;

        if (p == root || q == root) {
            return root;
        }

        TreeNode result = root;
        
        while (result != null) {
            if (result.val > p.val && result.val > q.val) {
                result = result.left;
            } else if (result.val < p.val && result.val < q.val) {
                result = result.right;
            } else {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args){

        new Solution2().lowestCommonAncestor(new TreeNode(1), new TreeNode(2), new TreeNode(3));
    }
}
