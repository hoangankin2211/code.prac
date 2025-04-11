import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class SubTreeAnotherTree {

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

    static class TreeNodeTrack {
        public int val;
        public boolean isLeaf;

        TreeNodeTrack() {
            this.val = 0;
            this.isLeaf = true;
        }

        TreeNodeTrack(int val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
        }
    }

    public boolean isSubtreeV1(TreeNode root, TreeNode subRoot) {
        if (Objects.isNull(root) || Objects.isNull(subRoot)) {
            return false;
        }

        List<TreeNodeTrack> rootList = new ArrayList<>();
        List<TreeNodeTrack> subRootList = new ArrayList<>();
        postOrderTraverser(root, rootList);
        postOrderTraverser(subRoot, subRootList);

        for (int i = 0; i < rootList.size(); i++) {
            if (rootList.get(i).isLeaf && rootList.get(i).val == subRootList.get(0).val) {
                boolean isOk = true;
                for (int j = 0; j < subRootList.size(); j++) {
                    if (i + j >= rootList.size()) {
                        isOk = false;
                        break;
                    }
                    if (rootList.get(i + j).val != subRootList.get(j).val) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    return true;
                }
            }
        }

        return false;
    }

    void postOrderTraverser(TreeNode root, List<TreeNodeTrack> list) {
        if (Objects.isNull(root)) {
            list.add(new TreeNodeTrack());
            return;
        }
        postOrderTraverser(root.left, list);
        postOrderTraverser(root.right, list);
        TreeNodeTrack treeNodeTrack = new TreeNodeTrack(root.val, false);
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            treeNodeTrack.isLeaf = true;
        }
        list.add(treeNodeTrack);
    }

    public boolean isSubtreeV2(TreeNode root, TreeNode subRoot) {
        if (Objects.isNull(root) || Objects.isNull(subRoot)) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == subRoot.val) {
                boolean isSmimilar = true;
                Queue<TreeNode> subQueue1 = new LinkedList<>();
                subQueue1.add(subRoot);
                Queue<TreeNode> subQueue2 = new LinkedList<>();
                subQueue2.add(node);

                while (true) {
                    if (subQueue1.isEmpty()) {
                        if (!subQueue2.isEmpty()) {
                            isSmimilar = false;
                        }
                        break;
                    }
                    if (subQueue2.isEmpty()) {
                        isSmimilar = false;
                        break;
                    }
                    TreeNode node1 = subQueue1.poll();
                    TreeNode node2 = subQueue2.poll();
                    if ((!Objects.isNull(node1) && Objects.isNull(node2))
                            || (Objects.isNull(node1) && !Objects.isNull(node2))) {
                        isSmimilar = false;
                        break;
                    }
                    if (Objects.isNull(node1) && Objects.isNull(node2)) {
                        continue;
                    }
                    if (node1.val != node2.val) {
                        isSmimilar = false;
                        break;
                    }
                    // if (!Objects.isNull(node1.left)) {
                    subQueue1.add(node1.left);
                    // }
                    // if (!Objects.isNull(node1.right)) {
                    subQueue1.add(node1.right);
                    // }
                    // if (!Objects.isNull(node2.left)) {
                    subQueue2.add(node2.left);
                    // }
                    // if (!Objects.isNull(node2.right)) {
                    subQueue2.add(node2.right);
                    // }
                }
                if (isSmimilar) {
                    return true;
                }
            }
            if (!Objects.isNull(node.left)) {
                queue.add(node.left);
            }
            if (!Objects.isNull(node.right)) {
                queue.add(node.right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        // TreeNode subroot = new TreeNode(4);
        TreeNode subroot = new TreeNode(4, new TreeNode(1), new TreeNode(2));

        // TreeNode root = new TreeNode(4, new TreeNode(5), null);
        // TreeNode subroot = new TreeNode(4, null, new TreeNode(5));
        System.out.println(new SubTreeAnotherTree().isSubtreeV2(root, subroot));
    }
}
// root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
