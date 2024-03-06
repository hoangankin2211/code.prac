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


 public class DiameterBinaryTree{
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        int left = height(root.left);
        int right = height(root.right);
        
        return Math.max(left + right,Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));
    }

    public int height(TreeNode node){
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    
    public static void main(String[] args) {
               
    }
}


//Solution For Zero Runtime
class DiameterBinaryTreeV2{
    int longestPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return longestPath;
    }

    public int height(TreeNode node){
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        longestPath = Math.max(longestPath,left + right);
        
        return Math.max(left, right) + 1;
    }

    
    public static void main(String[] args) {
               
    }
}