import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trees.bstree.HeapTree;

public class HeapTreeTest {
    private HeapTree<Integer> heaptree;

    @BeforeEach
    void setUp() {
        heaptree = new HeapTree<>();
        heaptree.insert(10);
        heaptree.insert(15);
        heaptree.insert(14);
        heaptree.insert(12);
    }

    @Test
    void searchTrueTest() {
        boolean result = heaptree.search(15);
        Assertions.assertTrue(result);
    }

    @Test
    void searchFalseTest() {
        boolean result = heaptree.search(17);
        Assertions.assertFalse(result);
    }

    @Test
    void deleteTrueTest() {
        boolean result = heaptree.delete(15);
        Assertions.assertTrue(result);
    }

    @Test
    void deleteFalseTest() {
        boolean result = heaptree.delete(17);
        Assertions.assertFalse(result);
    }
}
