package trees.bstree;

import trees.Tree;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {
    private class Node {
        T value;
        Node left, right;
        int height;

        public Node(T value) {
            this.value = value;
            this.height = 1;
        }
    }

    private Node root;

    @Override
    public void insert(T value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, T value) {
        if (node == null) return new Node(value);

        if (value.compareTo(node.value) < 0) {
            node.left = insertRec(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = insertRec(node.right, value);
        } else {
            return node; // Дубликаты не допускаются
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }

    @Override
    public boolean delete(T value) {
        if (search(value)) {
            root = deleteRec(root, value);
            return true;
        }
        return false;
    }

    private Node deleteRec(Node node, T value) {
        if (node == null) return null;
        if (value.compareTo(node.value) < 0) {
            node.left = deleteRec(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = deleteRec(node.right, value);
        } else {
            if (node.left == null || node.right == null) {
                Node temp = (node.left != null) ? node.left : node.right;
                node = temp;
            } else {
                Node temp = findMin(node.right);
                node.value = temp.value;
                node.right = deleteRec(node.right, temp.value);
            }
        }

        if (node == null) return null;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }

    private Node balance(Node node) {
        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (getBalanceFactor(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            node = rotateRight(node);
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            node = rotateLeft(node);
        }
        return node;
    }

    private int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    private int getBalanceFactor(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node T = x.left;

        x.left = y;
        y.right = T;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T = x.right;

        x.right = y;
        y.left = T;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    @Override
    public boolean search(T value) {
        return searchRec(root, value) != null;
    }

    private Node searchRec(Node node, T value) {
        if (node == null || node.value.equals(value)) return node;
        if (value.compareTo(node.value) < 0) return searchRec(node.left, value);
        return searchRec(node.right, value);
    }
}

