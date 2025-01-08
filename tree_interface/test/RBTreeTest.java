import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trees.bstree.RBTree;

public class RBTreeTest {
    private RBTree<Integer> rbtree;
    private RBTree<Integer> rbtree_test;

    @BeforeEach
    void setUpRBTree() {
        rbtree = new RBTree<>();
        rbtree.insert(10);
        rbtree.insert(15);
        rbtree.insert(14);
        rbtree.insert(12);
    }

    @BeforeEach
    void setUpRBTree_Test() {
        rbtree_test = new RBTree<>();
        rbtree_test.insert(10);
        rbtree_test.insert(14);
        rbtree_test.insert(12);
    }

    @Test
    void searchTrueTest() {
        boolean result = rbtree.search(15);
        Assertions.assertTrue(result);
    }

    @Test
    void searchFalseTest() {
        boolean result = rbtree.search(17);
        Assertions.assertFalse(result);
    }
}
