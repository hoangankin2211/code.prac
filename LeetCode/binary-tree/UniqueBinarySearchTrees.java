public class UniqueBinarySearchTrees {
    public static void main(String[] args) {

    }

    public static int numTrees(int n) {
        if (n == 1)
            return 1;
        return numTrees(n - 1) + numTrees(n - 2);
    }
}
