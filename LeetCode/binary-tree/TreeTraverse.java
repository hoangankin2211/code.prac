import java.util.*;

public class TreeTraverse{
    public static void preOrderTraverse(TreeNode root){
        if (root == null){
            return;
        } 
        System.out.println(root.val);
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    public static void inOrderTraverse(TreeNode root){
        if (root == null){
            return;
        } 
        inOrderTraverse(root.left);
        System.out.println(root.val);
        inOrderTraverse(root.right);
    }

    public static void postOrderTraverse(TreeNode root){
        if (root == null){
            return ;
        }
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.println(root.val);
    }

    public static void breathFirstSearch(TreeNode root){
        if (root == null){
            return;
        }

        Queue<TreeNode> queue  = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
    }
}