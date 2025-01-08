import trees.bstree.BinarySearchTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bstree;

    @BeforeEach
    void setUp() {
        bstree = new BinarySearchTree<>();
        bstree.insert(10);
        bstree.insert(15);
        bstree.insert(14);
        bstree.insert(12);
    }

    @Test
    void searchTrueTest() {
        boolean result = bstree.search(15);
        Assertions.assertTrue(result);
    }

    @Test
    void searchFalseTest() {
        boolean result = bstree.search(17);
        Assertions.assertFalse(result);
    }

    @Test
    void deleteTrueTest() {
        boolean result = bstree.delete(15);
        Assertions.assertTrue(result);
    }

    @Test
    void deleteFalseTest() {
        boolean result = bstree.delete(17);
        Assertions.assertFalse(result);
    }
}
