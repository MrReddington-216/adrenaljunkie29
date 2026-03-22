public class Main {

    // -------------------
    // Binary Search Tree
    // -------------------
    static class BinarySearchTree<T extends Comparable<T>> {

        // Node class represents each element in the BST
        private class Node {
            T data;
            Node left, right;
            Node(T data) {
                this.data = data;
                left = right = null;
            }
        }

        private Node root; // Root of the BST

        // Constructor
        public BinarySearchTree() {
            root = null;
        }

        // -------------------
        // INSERTION
        // -------------------
        public void insert(T value) {
            root = insertRec(root, value);
        }

        private Node insertRec(Node root, T value) {
            if (root == null) return new Node(value); // Insert at leaf
            if (value.compareTo(root.data) < 0) root.left = insertRec(root.left, value);
            else if (value.compareTo(root.data) > 0) root.right = insertRec(root.right, value);
            return root;
        }

        // -------------------
        // DELETION
        // -------------------
        public void delete(T value) {
            root = deleteRec(root, value);
        }

        private Node deleteRec(Node root, T value) {
            if (root == null) return root;

            if (value.compareTo(root.data) < 0) {
                root.left = deleteRec(root.left, value);
            } else if (value.compareTo(root.data) > 0) {
                root.right = deleteRec(root.right, value);
            } else {
                // Node found, handle deletion
                if (root.left == null) return root.right;
                else if (root.right == null) return root.left;

                // Node with two children: get inorder successor
                root.data = minValue(root.right);
                root.right = deleteRec(root.right, root.data);
            }
            return root;
        }

        private T minValue(Node node) {
            T minv = node.data;
            while (node.left != null) {
                node = node.left;
                minv = node.data;
            }
            return minv;
        }

        // -------------------
        // INORDER Traversal (Left -> Root -> Right)
        // -------------------
        public void inorder() {
            inorderRec(root);
            System.out.println();
        }

        private void inorderRec(Node node) {
            if (node != null) {
                inorderRec(node.left);
                System.out.print(node.data + " ");
                inorderRec(node.right);
            }
        }

        // -------------------
        // POSTORDER Traversal (Left -> Right -> Root)
        // -------------------
        public void postorder() {
            postorderRec(root);
            System.out.println();
        }

        private void postorderRec(Node node) {
            if (node != null) {
                postorderRec(node.left);
                postorderRec(node.right);
                System.out.print(node.data + " ");
            }
        }

        // -------------------
        // PREORDER Traversal (Root -> Left -> Right)
        // -------------------
        public void preorder() {
            preorderRec(root);
            System.out.println();
        }

        private void preorderRec(Node node) {
            if (node != null) {
                System.out.print(node.data + " ");
                preorderRec(node.left);
                preorderRec(node.right);
            }
        }

        // -------------------
        // SEARCH for a value
        // -------------------
        public boolean search(T value) {
            return searchRec(root, value);
        }

        private boolean searchRec(Node node, T value) {
            if (node == null) return false;
            if (value.equals(node.data)) return true;
            return value.compareTo(node.data) < 0 ? searchRec(node.left, value) : searchRec(node.right, value);
        }

        // -------------------
        // PATH from root to value
        // -------------------
        public String path(T value) {
            StringBuilder sb = new StringBuilder();
            if (pathRec(root, value, sb)) return sb.toString();
            return "Value not found";
        }

        private boolean pathRec(Node node, T value, StringBuilder sb) {
            if (node == null) return false;
            sb.append(node.data);
            if (node.data.equals(value)) return true;

            sb.append(" -> ");
            if (value.compareTo(node.data) < 0) {
                if (pathRec(node.left, value, sb)) return true;
            } else {
                if (pathRec(node.right, value, sb)) return true;
            }

            // Backtrack if not found
            sb.setLength(sb.length() - (sb.length() >= 4 ? 4 : 0)); // remove last " -> "
            return false;
        }
    }

    // -------------------
    // MAIN METHOD
    // -------------------
    public static void main(String[] args) {
        // Create BST object
        BinarySearchTree<Integer> lab5Tree = new BinarySearchTree<>();

        // Insert values
        int[] values = {13, 22, 36, 5, 48, 17, 39, 2, 26, 40, 29, 34, 10};
        for (int val : values) lab5Tree.insert(val);

        // Traversals before deletion
        System.out.println("Inorder traversal before deleting 17:");
        lab5Tree.inorder();

        System.out.println("Postorder traversal before deleting 17:");
        lab5Tree.postorder();

        // Delete node 17
        lab5Tree.delete(17);

        // Traversals after deletion
        System.out.println("\nInorder traversal after deleting 17:");
        lab5Tree.inorder();

        System.out.println("Postorder traversal after deleting 17:");
        lab5Tree.postorder();

        // Preorder traversal
        System.out.println("\nPreorder traversal:");
        lab5Tree.preorder();

        // Search examples
        System.out.println("\nSearch 36: " + lab5Tree.search(36));
        System.out.println("Search 37: " + lab5Tree.search(37));

        // Display paths
        System.out.println("\nPath to 2: " + lab5Tree.path(2));
        System.out.println("Path to 34: " + lab5Tree.path(34));
    }
}