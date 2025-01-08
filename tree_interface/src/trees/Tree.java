package trees;

public interface Tree<T extends Comparable<T>> {
    void insert(T value);
    boolean delete(T value);
    boolean search(T value);
}
