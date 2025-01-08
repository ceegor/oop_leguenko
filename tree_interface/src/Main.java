import trees.bstree.AVLTree;
import trees.bstree.RBTree;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ///////////////////////////////////////
//        BinarySearchTree<Integer> bstree = new BinarySearchTree<>();
//        bstree.insert(5);
//        bstree.insert(6);
//        bstree.insert(1);
//        bstree.insert(9);
//        bstree.delete(9);
//        bstree.insert(10);
//        bstree.insert(7);
//        bstree.insert(8);
//        bstree.delete(5);
//        bstree.printTree();
        ///////////////////////////////////////
        RBTree<Integer> rbtree = new RBTree<>();
        rbtree.insert(10);
        rbtree.insert(40);
        rbtree.insert(11);
        rbtree.insert(15);
        rbtree.delete(10);
        System.out.println(rbtree.search(11));
        AVLTree<Integer> avltree = new AVLTree<>();
//        avltree.insert(10);
//        avltree.insert(15);
//        avltree.insert(13);
//        avltree.delete(10);
//        System.out.println(avltree.search(13));
    }
}
