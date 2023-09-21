public class BinaryTree extends Tree{

    public TreeNode add(int val){
        if (root == null){
            root = new TreeNode(val);
            return root;
        }
        TreeNode temp = root;
        TreeNode parent = null;
        while (temp!=null){
            parent = temp;
            
            if (temp.val > val){
                temp = temp.left;                
            }
            else if (temp.val < val){
                temp = temp.right;     
            }
            else {
                return null;
            }
        }

        TreeNode newNode = new TreeNode(val); 
        
        if (parent.val > val){
            parent.left = newNode;
        }
        else{
            parent.right = newNode;
        }
        
        return newNode;
    }

    public TreeNode search(int val){
        if (root == null){
            return null;
        }

        TreeNode cur = root;
        
        while (cur != null){
            if (cur.val > val){
                cur = cur.left;
            }
            else if (cur.val < val){
                cur = cur.right;
            }
            else {
                return cur;
            }
        }
        
        return null;
    }


    public boolean delete(int val){
        if (root == null){
            return false;
        }

        TreeNode deleteNode = search(val);

        if (deleteNode.left != null && deleteNode.right != null){
            
        }
        else{
            if (deleteNode.left == null){
            }
            else {

            }
        }

        return true;        
    }

    // height = -1 -> the tree is empty
    // height = 0 -> the tree have only one node
    public int height(){
        return _findHeight(root);
    }


    private int _findHeight(TreeNode node){
        if (node == null){
            return -1;
        }
        
        int leftHeight = 1 + _findHeight(node.left);
        int rightHeight = 1 + _findHeight(node.right);
        
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
}