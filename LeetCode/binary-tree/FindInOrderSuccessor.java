public class FindInOrderSuccessor{
    static Node getSuccessor(Node root){
        if (root == null) return null;
        return mostLeftOf(root.right);
    }

    static Node mostLeftOf(Node node){
        if (node == null) return null;
        Node left = mostLeftOf(node.left);
        if (left!=null) return left;
        return node;
    }
    public static void main(String[] args) {
        Node root = new Node(20);
        root = root.insert(root, 8);
        root = root.insert(root, 22);
        root = root.insert(root, 4);
        root = root.insert(root, 12);
        root = root.insert(root, 10);
        root = root.insert(root, 14);

        System.err.println(getSuccessor(root.left.right).data);
    }
}

class Node {
 
    int data;
    Node left, right, parent;
 
    Node(int d)
    {
        data = d;
        left = right = parent = null;
    }

    Node insert(Node node, int data)
    {
 
        /* 1. If the tree is empty, return a new,     
         single node */
        if (node == null) {
            return (new Node(data));
        }
        else {
 
            Node temp = null;
 
            /* 2. Otherwise, recur down the tree */
            if (data <= node.data) {
                temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;
            }
            else {
                temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }
 
            /* return the (unchanged) node pointer */
            return node;
        }
    }
}
 