public class Main{
    
    public static boolean isSubTreeLesser(TreeNode root,int val){
        if (root == null){
            return true;
        }
        
        if (root.val < val 
        && isSubTreeLesser(root.left,val) 
        && isSubTreeLesser(root.right,val)) return true;
        
        return false;
    }

    public static boolean isSubTreeGreater(TreeNode root,int val){
        if (root == null){
            return true;
        }
         
        if (root.val > val  
        && isSubTreeGreater(root.left,val) 
        && isSubTreeGreater(root.right,val)) return true;
        
        return false;
    } 
    
    public static boolean isBinarySearchTree(TreeNode root){
        if (root == null){
            return true;    
        }

        if (isSubTreeLesser(root.left,root.val) 
        && isSubTreeGreater(root.right,root.val)
        && isBinarySearchTree(root.left)
        && isBinarySearchTree(root.right))
        {
            return true;
        }
        return false;
    } 


    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.add(3);
        tree.add(5);
        tree.add(1);
        tree.add(2);
        tree.add(7);
        tree.add(4);
        System.out.println(tree.add(6));
        System.out.println(tree.search(1));
        
        // TreeTraverse.postOrderTraverse(tree.root);
    }
}