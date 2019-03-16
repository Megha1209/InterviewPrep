package tree;

import static tree.TreeNode.height;
import static tree.TreeTraversal.inOrderTraversalIterative;
import static tree.TreeTraversal.inOrderTraversalRecursive;

public class BinarySearchTree {
    static TreeNode insertRecursive(TreeNode root, int newValue) {
        if (root == null) {
            return new TreeNode(newValue);
        }
        if (root.value > newValue) {
            root.left = insertRecursive(root.left, newValue);
        } else {
            root.right = insertRecursive(root.right, newValue);
        }
        return root;
    }

    static TreeNode insertIterative(TreeNode root, int newValue) {
        TreeNode child = new TreeNode(newValue);
        if (root == null) {
            return child;
        }
        TreeNode current = root;
        TreeNode prev = null;
        while (current != null) {
            prev = current;
            if (current.value > newValue) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (prev.value > newValue) {
            prev.left = new TreeNode(newValue);
        } else {
            prev.right = new TreeNode(newValue);
        }
        return root;
    }

    static boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.value < root.left.value) {
            return false;
        }
        if (root.right != null && root.value > root.right.value) {
            return false;
        }
        return isBST(root.left) && isBST(root.right);
    }

    static boolean search(TreeNode root, int value) {
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        } else if (root.value > value) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

    static TreeNode createBSTRecursive() {
        TreeNode root = insertRecursive(null, 33);
        insertRecursive(root, 20);
        insertRecursive(root, 45);
        insertRecursive(root, 19);
        insertRecursive(root, 27);
        insertRecursive(root, 30);
        insertRecursive(root, 87);
        insertRecursive(root, 40);
        insertRecursive(root, 67);
        inOrderTraversalRecursive(root);
        return root;
    }

    static TreeNode createBSTIterative() {
        TreeNode root = insertIterative(null, 33);
        insertIterative(root, 20);
        insertIterative(root, 45);
        insertIterative(root, 19);
        insertIterative(root, 27);
        insertIterative(root, 30);
        insertIterative(root, 87);
        insertIterative(root, 40);
        insertIterative(root, 67);
        inOrderTraversalIterative(root);
        return root;
    }

    public static void main(String[] args) {
        System.out.print("BST recursive: ");
        TreeNode root = createBSTRecursive();
        System.out.println("\nHeight: " + height(root));
        System.out.println("isBST: " + isBST(root));
        System.out.println("Find 40: " + search(root, 40));
        System.out.println("Find 18: " + search(root, 18));

        System.out.print("\nBST iterative: ");
        root = createBSTIterative();
        System.out.println("Height: " + height(root));
        System.out.println("isBST: " + isBST(root));
        System.out.println("Find 49: " + search(root, 49));
        System.out.println("Find 87: " + search(root, 87));

        root = TreeNode.createTree();
        inOrderTraversalRecursive(root);
        System.out.println("\nHeight: " + height(root));
        System.out.println("isBST: " + isBST(root));

        root = TreeNode.createBalancedTree();
        inOrderTraversalRecursive(root);
        System.out.println("\nHeight: " + height(root));
        System.out.println("isBST: " + isBST(root));
    }
}
