package trees.bstree;

import trees.Tree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private class Node {
        T value;
        Node left, right;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node root;

    @Override
    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node node, T value) {
        if (node == null) {
            return new Node(value);
        }
        if (value.compareTo(node.value) < 0) {
            node.left = insertRecursive(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    private void printTreeRecursive(Node node, String indent, boolean isRight) {
        if (node != null) {
            System.out.println(indent + (isRight ? "R---- " : "L---- ") + node.value);
            printTreeRecursive(node.left, indent + (isRight ? "|     " : "      "), false);
            printTreeRecursive(node.right, indent + (isRight ? "|     " : "      "), true);
        }
    }

    @Override
    public boolean delete(T value) {
        if (search(value)) {
            root = deleteRecursive(root, value);
            return true;
        }
        return false;
    }

    private Node deleteRecursive(Node node, T value) {
        if (node == null) return null;
        if (value.compareTo(node.value) < 0) {
            node.left = deleteRecursive(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = deleteRecursive(node.right, value);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            T smallestValue = findMin(node.right);
            node.value = smallestValue;
            node.right = deleteRecursive(node.right, smallestValue);
        }
        return node;
    }

    private T findMin(Node node) {
        return node.left == null ? node.value : findMin(node.left);
    }

    @Override
    public boolean search(T value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(Node node, T value) {
        if (node == null) return false;
        if (value.equals(node.value)) return true;
        return value.compareTo(node.value) < 0 ? searchRecursive(node.left, value) : searchRecursive(node.right, value);
    }
}
