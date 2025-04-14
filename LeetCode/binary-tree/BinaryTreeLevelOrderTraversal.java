import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(root)) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int count = 0;
            int length = queue.size();
            while (!queue.isEmpty()) {
                if (count == length){
                    break;
                }
                TreeNode node = queue.poll();
                list.add(node.val);
                if (!Objects.isNull(node.left)){
                    queue.add(node.left);
                }
                if (!Objects.isNull(node.right)){
                    queue.add(node.right);
                }
                count++;
            }    
            result.add(list);
        }

        return result;
    }
    public static void main(String[] args){
        // [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(root));
    }
}
