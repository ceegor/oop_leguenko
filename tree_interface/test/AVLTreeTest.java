import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trees.bstree.AVLTree;

public class AVLTreeTest {
    private AVLTree<Integer> avltree;

    @BeforeEach
    void setUp() {
        avltree = new AVLTree<>();
        avltree.insert(10);
        avltree.insert(15);
        avltree.insert(14);
        avltree.insert(12);
    }

    @Test
    void searchTrueTest() {
        boolean result = avltree.search(15);
        Assertions.assertTrue(result);
    }

    @Test
    void searchFalseTest() {
        boolean result = avltree.search(17);
        Assertions.assertFalse(result);
    }

    @Test
    void deleteTrueTest() {
        boolean result = avltree.delete(15);
        Assertions.assertTrue(result);
    }

    @Test
    void deleteFalseTest() {
        boolean result = avltree.delete(17);
        Assertions.assertFalse(result);
    }
}
